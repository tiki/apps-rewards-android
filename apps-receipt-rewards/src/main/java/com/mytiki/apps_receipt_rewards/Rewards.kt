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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.mytiki.apps_receipt_rewards.account.AccountService
import com.mytiki.apps_receipt_rewards.capture.CaptureService
import com.mytiki.apps_receipt_rewards.email.OAuth
import com.mytiki.apps_receipt_rewards.license.Company
import com.mytiki.apps_receipt_rewards.license.License
import com.mytiki.apps_receipt_rewards.license.LicenseService
import com.mytiki.capture.receipt.CaptureReceipt
import com.mytiki.capture.receipt.Configuration
import java.util.UUID
import kotlin.coroutines.coroutineContext

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
     * The current color font family.
     */
    var fontFamily: FontFamily = Theme().fontFamily
        private set

    /**
     * The current color scheme.
     */
    var colorScheme: ColorScheme = lightColorScheme(
        primary = Theme().accentColor,
        error = Color(0xFFC73000),
        background = Theme().primaryBackgroundColor,
        onBackground = Theme().secondaryBackgroundColor,
        outline = Theme().primaryTextColor,
        outlineVariant = Theme().secondaryTextColor,
    )
        private set

    var company: Company = Company(
        "Company Inc.",
        "Tennessee, USA",
        "https://your-co.com/privacy",
        "https://your-co.com/terms",
    )
      private set

    var licenseConfig: License = License(
        "be19730a-00d5-45f5-b18e-2e19eb25f311",
        "sRwAAAAoY29tLm15dGlraS5zZGsuY2FwdHVyZS5yZWNlaXB0LmNhcGFjaXRvcgY6SQlVDCCrMOCc/jLI1A3BmOhqNvtZLzShMcb3/OLQLiqgWjuHuFiqGfg4fnAiPtRcc5uRJ6bCBRkg8EsKabMQkEsMOuVjvEOejVD497WkMgobMbk/X+bdfhPPGdcAHWn5Vnz86SmGdHX5xs6RgYe5jmJCSLiPmB7cjWmxY5ihkCG12Q==",
        "wSNX3mu+YGc/2I1DDd0NmrYHS6zS1BQt2geMUH7DDowER43JGeJRUErOHVwU2tz6xHDXia8BuvXQI3j37I0uYw=="
    )
        private set

    var oauth: OAuth = OAuth(null, null)
        private set

    var userId: String = UUID.randomUUID().toString()
        private set

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
        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)

        // Configure the receipt capture system
        CaptureReceipt.config(
            Configuration(
                licenseConfig.tikiPublishingID,
                licenseConfig.microblinkLicenseKey,
                licenseConfig.productIntelligenceKey,
                license.terms(),
                oauth.gmailAPIKey,
                oauth.outlookAPIKey
            )
        ){ onError(context, it.message.toString(), "CaptureReceipt Configuration Error")}

        // Initialize the receipt capture system for a user
        CaptureReceipt.initialize(this.userId, context){ onError(context, it.message.toString(), "CaptureReceipt Configuration Error")}
    }

    fun company(
        name: String,
        jurisdiction: String,
        privacy: String,
        terms: String
    ){
        company = Company(name, jurisdiction, privacy, terms)
    }

    fun licenses(
        tikiPublishingID: String,
        microblinkLicenseKey: String,
        productIntelligenceKey: String,
    ){
        licenseConfig = License(tikiPublishingID, microblinkLicenseKey, productIntelligenceKey)
    }

    fun oauth(
        gmailAPIKey: String?,
        outlookAPIKey: String?,
        context: Context? = null,
        userId: String? = null
    ){
        oauth = OAuth(gmailAPIKey, outlookAPIKey)
        if (context != null && !userId.isNullOrEmpty()) {
            initialize(context, userId)
        }
    }

    fun theme(
         primaryTextColor: Color,
         secondaryTextColor: Color,
         primaryBackgroundColor: Color,
         secondaryBackgroundColor: Color,
         accentColor: Color,
         fontFamily: FontFamily
    ){
        colorScheme = lightColorScheme(
            primary = accentColor,
            error = Color(0xFFC73000),
            background = primaryBackgroundColor,
            onBackground = secondaryBackgroundColor,
            outline = primaryTextColor,
            outlineVariant = secondaryTextColor,
        )
        this.fontFamily = fontFamily
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
        CaptureReceipt.logout(context, {
            userId = UUID.randomUUID().toString()
        }){
            onError(context, "Logout didn't work, please try again later")
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
