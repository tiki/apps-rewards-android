/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.mytiki.apps_receipt_rewards.account.AccountService
import com.mytiki.apps_receipt_rewards.capture.CaptureService
import com.mytiki.apps_receipt_rewards.license.LicenseService
import com.mytiki.capture.receipt.CaptureReceipt
import com.mytiki.capture.receipt.Configuration
import java.util.UUID

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
 * Rewards.start(context)
 *
 * // Start rewards system with a custom theme
 * val customTheme = Theme(
 *      primaryTextColor = Color.Black,
 *      secondaryTextColor = Color.Gray,
 *      primaryBackgroundColor = Color.White,
 *      secondaryBackgroundColor = Color.LightGray,
 *      accentColor = Color.Blue,
 *      fontFamily = FontFamily.Serif
 * )
 * Rewards.start(context, customTheme)
 * ```
 */
object Rewards {
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

    val theme: ThemeService = ThemeService()


    private var userId: String = UUID.randomUUID().toString()

    /**
     * Initializes the rewards system and presents the home screen.
     *
     * @param context The application context.
     * @param appTheme An optional parameter to set a custom theme. If not provided, the default theme is used.
     *
     * The home screen is presented modally with a cross-dissolve transition and a semi-transparent background.
     */
    fun initialize(
        context: Context,
        userId: String
    ) {
        this.userId = userId

        // Configure the receipt capture system
        CaptureReceipt.config(
            Configuration(
                license.licenseKeys.tikiPublishingID,
                license.licenseKeys.microblinkLicenseKey,
                license.licenseKeys.productIntelligenceKey,
                license.terms(),
                capture.authKeys.gmailAPIKey,
                capture.authKeys.outlookAPIKey
            )
        ){ onError(context, it.message.toString(), "CaptureReceipt Configuration Error")}

        // Initialize the receipt capture system for a user
        CaptureReceipt.initialize(this.userId, context){ onError(context, it.message.toString(), "CaptureReceipt Configuration Error")}

        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)
    }

    fun company(
        name: String,
        jurisdiction: String,
        privacy: String,
        terms: String
    ){
        license.company(name, jurisdiction, privacy, terms)
    }

    fun licenses(
        tikiPublishingID: String,
        microblinkLicenseKey: String,
        productIntelligenceKey: String,
    ){
        license.licenses(tikiPublishingID, microblinkLicenseKey, productIntelligenceKey)
    }

    fun oauth(
        gmailAPIKey: String?,
        outlookAPIKey: String?,
        context: Context? = null,
        userId: String? = null
    ){
        capture.oauth(gmailAPIKey, outlookAPIKey, context, userId)
    }

    fun theme(
        primaryTextColor: Color,
        secondaryTextColor: Color,
        primaryBackgroundColor: Color,
        secondaryBackgroundColor: Color,
        accentColor: Color,
        fontFamily: FontFamily
    ){
        theme.theme(primaryTextColor, secondaryTextColor, primaryBackgroundColor, secondaryBackgroundColor, accentColor, fontFamily)
    }


    fun config(
        context: Context,
        userId: String,
        companyName: String,
        companyJurisdiction: String,
        privacy: String,
        terms: String,
        tikiPublishingID: String,
        microblinkLicenseKey: String,
        productIntelligenceKey: String,
        gmailAPIKey: String? = null,
        outlookAPIKey: String? = null,
        primaryTextColor: Color = Theme().primaryTextColor, // optional
        secondaryTextColor: Color = Theme().secondaryTextColor, // optional
        primaryBackgroundColor: Color = Theme().primaryBackgroundColor, // optional
        secondaryBackgroundColor: Color = Theme().secondaryBackgroundColor, // optional
        accentColor: Color = Theme().accentColor, // optional
        fontFamily: FontFamily = Theme().fontFamily,
    ){
        company(companyName, companyJurisdiction, privacy, terms)
        licenses(tikiPublishingID, microblinkLicenseKey, productIntelligenceKey)
        oauth( gmailAPIKey, outlookAPIKey)
        theme(primaryTextColor, secondaryTextColor, primaryBackgroundColor, secondaryBackgroundColor, accentColor, fontFamily)
        initialize(context, userId)
    }

    fun logout(context: Context){
        account.logout(context){
            userId = UUID.randomUUID().toString()
        }
    }


    fun onError(context: Context,message: String,title: String? = null){

        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
            .show()
    }
}
