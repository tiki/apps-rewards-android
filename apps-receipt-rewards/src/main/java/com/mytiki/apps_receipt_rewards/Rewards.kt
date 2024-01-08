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
import com.mytiki.apps_receipt_rewards.card.Card
import com.mytiki.apps_receipt_rewards.card.CardService
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

    /**
     * An instance of [ThemeService] for managing the app's theme.
     */
    val theme: ThemeService = ThemeService()

    /**
     * An instance of [CardService] for managing user cards.
     */
    val card: CardService = CardService()

    private var userId: String = UUID.randomUUID().toString()

    /**
     * Initializes the rewards system and presents the home screen.
     *
     * @param context The application context.
     * @param userId The unique identifier of the user.
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

    /**
     * Configures company details for licensing purposes.
     *
     * @param name The name of the company.
     * @param jurisdiction The jurisdiction of the company.
     * @param privacy The privacy policy of the company.
     * @param terms The terms and conditions of the company.
     */
    fun company(
        name: String,
        jurisdiction: String,
        privacy: String,
        terms: String
    ){
        license.company(name, jurisdiction, privacy, terms)
    }

    /**
     * Configures license keys required for services.
     *
     * @param tikiPublishingID The TIKI publishing ID.
     * @param microblinkLicenseKey The Microblink license key.
     * @param productIntelligenceKey The product intelligence key.
     */
    fun licenses(
        tikiPublishingID: String,
        microblinkLicenseKey: String,
        productIntelligenceKey: String,
    ){
        license.licenses(tikiPublishingID, microblinkLicenseKey, productIntelligenceKey)
    }

    /**
     * Configures OAuth keys for 3rd party services.
     *
     * @param gmailAPIKey The API key for Gmail.
     * @param outlookAPIKey The API key for Outlook.
     * @param context The application context.
     * @param userId The unique identifier of the user.
     */
    fun oauth(
        gmailAPIKey: String?,
        outlookAPIKey: String?,
        context: Context? = null,
        userId: String? = null
    ){
        capture.oauth(gmailAPIKey, outlookAPIKey, context, userId)
    }

    /**
     * Configures the app's theme.
     *
     * @param primaryTextColor The primary text color.
     * @param secondaryTextColor The secondary text color.
     * @param primaryBackgroundColor The primary background color.
     * @param secondaryBackgroundColor The secondary background color.
     * @param accentColor The accent color.
     * @param fontFamily The font family to be used.
     */
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


    /**
     * Configures various settings and initializes the rewards system.
     * This function combines company details, licenses, OAuth keys, theme, and initialization.
     *
     * @param context The application context.
     * @param userId The unique identifier of the user.
     * @param companyName The name of the company.
     * @param companyJurisdiction The jurisdiction of the company.
     * @param privacy The privacy policy of the company.
     * @param terms The terms and conditions of the company.
     * @param tikiPublishingID The TIKI publishing ID.
     * @param microblinkLicenseKey The Microblink license key.
     * @param productIntelligenceKey The product intelligence key.
     * @param gmailAPIKey The API key for Gmail.
     * @param outlookAPIKey The API key for Outlook.
     * @param primaryTextColor The primary text color (optional).
     * @param secondaryTextColor The secondary text color (optional).
     * @param primaryBackgroundColor The primary background color (optional).
     * @param secondaryBackgroundColor The secondary background color (optional).
     * @param accentColor The accent color (optional).
     * @param fontFamily The font family to be used (optional).
     */
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

    /**
     * Logs out the user from the account.
     *
     * @param context The application context.
     */
    fun logout(context: Context){
        account.logout(context){
            userId = UUID.randomUUID().toString()
        }
    }

    /**
     * Adds one or more user cards.
     *
     * @param cards The cards to be added.
     * @return List of cards after addition.
     */
    fun cards(vararg cards: Card): List<Card>{
        card.addCard(cards.toList())
        return card.getCards()
    }

    /**
     * Adds a list of user cards.
     *
     * @param cards The list of cards to be added.
     * @return List of cards after addition.
     */
    fun cards(cards: List<Card>): List<Card>{
        card.addCard(cards)
        return card.getCards()
    }

    /**
     * Retrieves the list of user cards.
     *
     * @return List of user cards.
     */
    fun cards() = card.getCards()

    /**
     * Removes a user card.
     *
     * @param card The card to be removed.
     */
    fun removeCard(card: Card){
        this.card.removeCard(card)
    }


    /**
     * Displays an error dialog with the given message and title.
     *
     * @param context The application context.
     * @param message The error message to display.
     * @param title The title of the error dialog (optional).
     */
    fun onError(context: Context, message: String, title: String? = null){

        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
            .show()
    }
}
