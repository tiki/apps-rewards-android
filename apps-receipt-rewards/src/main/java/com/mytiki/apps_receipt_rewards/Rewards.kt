package com.mytiki.apps_receipt_rewards

/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

import android.content.Context
import android.content.Intent
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.mytiki.apps_receipt_rewards.account.AccountService
import com.mytiki.apps_receipt_rewards.capture.CaptureService
import com.mytiki.apps_receipt_rewards.license.LicenseService

/**
 * [Rewards] class is the main API to interact with TIKI Rewards program.
 *
 * ## Overview
 *
 * The Rewards class works as a singleton and initializes the services for:
 * - theming: [Theme]
 * - 3rd party account management: [AccountService]
 * - capture user data: [CaptureService]
 * - data license handling: [LicenseService]
 *
 * ## Example
 *
 * To get started with the rewards system, use the following example:
 *
 * ```kotlin
 * // Start rewards system with default theme
 * Rewards.start()
 *
 * // Start rewards system with a custom theme
 * ```
 * Rewards.start(
 *   Theme(
 *      primaryTextColor = <Color>,
 *      secondaryTextColor = <Color>,
 *      primaryBackgroundColor = <Color>,
 *      secondaryBackgroundColor = <Color>,
 *      accentColor = <Color>,
 *      fontFamily = <Font Family>
 * ))
 * ```
 */
object Rewards {
    lateinit var colorScheme: ColorScheme
        private set

    lateinit var fontFamily: FontFamily
        private set

    /**
     * The current theme.
     */
    var theme: Theme = Theme()

    /**
     * An instance of [AccountService] for managing 3rd party accounts.
     */
    val account: AccountService = AccountService()

    /**
     * An instance of [CaptureService] for handling data capture functionalities.
     */
    val capture: CaptureService = CaptureService()

    /**
     * An instance of [LicenseService] for managing data licenses.
     */
    val license: LicenseService = LicenseService()

    /**
     * Initializes the rewards system and presents the home screen.
     *
     * @param theme An optional parameter to set a custom theme. If not provided, the default theme is used.
     *
     * The home screen is presented modally with a cross-dissolve transition and a semi-transparent background.
     */
    fun start(
        context: Context,
        theme: Theme = Theme()
    ) {
        colorScheme = lightColorScheme(
            primary = theme.accentColor,
            error = Color(0xFFC73000),
            background = theme.primaryBackgroundColor,
            onBackground = theme.secondaryBackgroundColor,
            outline = theme.primaryTextColor,
            outlineVariant = theme.secondaryTextColor,
        )
        this.fontFamily = theme.fontFamily
        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)
    }
}

