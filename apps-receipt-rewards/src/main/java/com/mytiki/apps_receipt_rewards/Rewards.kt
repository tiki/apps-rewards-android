/*
 * Copyright (c) TIKI Inc.
 * MIT license. See LICENSE file in the root directory.
 */

package com.mytiki.apps_receipt_rewards

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import com.mytiki.apps_receipt_rewards.account.AccountService
import com.mytiki.apps_receipt_rewards.capture.CaptureService
import com.mytiki.apps_receipt_rewards.license.Company
import com.mytiki.apps_receipt_rewards.license.LicenseService
import com.mytiki.capture.receipt.CaptureReceipt
import com.mytiki.capture.receipt.Configuration

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
    fun start(
        context: Context,
        appTheme: Theme = Theme()
    ) {
        colorScheme = lightColorScheme(
            primary = appTheme.accentColor,
            error = Color(0xFFC73000),
            background = appTheme.primaryBackgroundColor,
            onBackground = appTheme.secondaryBackgroundColor,
            outline = appTheme.primaryTextColor,
            outlineVariant = appTheme.secondaryTextColor,
        )
        this.fontFamily = appTheme.fontFamily
        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)

        // Configure the receipt capture system
        CaptureReceipt.config(
            Configuration(
                "be19730a-00d5-45f5-b18e-2e19eb25f311",
                "sRwAAAAoY29tLm15dGlraS5zZGsuY2FwdHVyZS5yZWNlaXB0LmNhcGFjaXRvcgY6SQlVDCCrMOCc/jLI1A3BmOhqNvtZLzShMcb3/OLQLiqgWjuHuFiqGfg4fnAiPtRcc5uRJ6bCBRkg8EsKabMQkEsMOuVjvEOejVD497WkMgobMbk/X+bdfhPPGdcAHWn5Vnz86SmGdHX5xs6RgYe5jmJCSLiPmB7cjWmxY5ihkCG12Q==",
                "wSNX3mu+YGc/2I1DDd0NmrYHS6zS1BQt2geMUH7DDowER43JGeJRUErOHVwU2tz6xHDXia8BuvXQI3j37I0uYw==",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus lobortis risus ac ultrices faucibus. Nullam vel pulvinar neque. Morbi ultrices maximus est, quis blandit urna vestibulum nec. Morbi et finibus nisi. Vestibulum dignissim rutrum mi sit amet sagittis. Aenean id ligula eget enim feugiat luctus vitae vitae orci. Maecenas aliquam semper nunc vel pellentesque. Ut cursus neque non est mattis consequat. Duis posuere odio et tellus aliquam, et tristique erat pharetra. Mauris sollicitudin lorem ligula. Ut lacinia, neque ac ornare gravida, libero turpis fermentum nibh, eget sodales diam magna sit amet lacus. Aliquam pretium suscipit mi eget luctus. Aliquam ut velit ut magna elementum sollicitudin in et magna. Ut a elementum tellus, eu cursus lacus. Pellentesque neque nisi, semper ac mi vel, fringilla semper nisl. Morbi at vulputate lectus, non ornare nulla." +
                "Vestibulum convallis rutrum tellus sed vulputate. Suspendisse condimentum mauris quis odio aliquet, at posuere augue egestas. Nulla finibus nibh ac placerat pretium. Mauris volutpat urna sit amet vehicula fermentum. Praesent semper est diam, sit amet elementum orci luctus ac. Quisque condimentum ipsum in venenatis rutrum. Donec rutrum nisl id elit porttitor, vel scelerisque quam ultricies. Donec vulputate, mi at tempor hendrerit, risus tortor consequat neque, non laoreet orci ante tempor dolor. Curabitur placerat convallis risus, a facilisis diam mollis in." +
                "Mauris in ex dolor. Nunc eu mollis mi. Integer ut nulla egestas, finibus tellus in, congue sem. Vestibulum sit amet velit cursus, consequat purus id, porttitor ligula. Aliquam pellentesque non augue quis tincidunt. Duis a pulvinar odio, non ultrices metus. Sed eu risus quam. Nam vehicula ligula id aliquet aliquet. Quisque faucibus odio pulvinar tellus tristique, eget tempus tellus accumsan. Nulla vehicula nunc quis dapibus lobortis. Sed urna magna, commodo vitae enim eget, scelerisque hendrerit mi. Pellentesque lobortis lectus vitae convallis facilisis." +
                "Phasellus lobortis purus sit amet sodales efficitur. Mauris sapien lorem, pretium id turpis eu, tristique maximus tellus. Donec porttitor, enim ut scelerisque dapibus, lectus tellus laoreet ante, a ornare dolor nisi sed risus. Vestibulum facilisis mollis urna in suscipit. Pellentesque sit amet lobortis nulla. Fusce semper rhoncus urna a gravida. In congue nec nisi eu hendrerit. Donec sed felis elementum lacus posuere porttitor eget quis dolor. Maecenas eu iaculis dolor. Nam venenatis tempor velit vel finibus. Phasellus purus nunc, condimentum sit amet porttitor nec, rhoncus et ante. Fusce tristique nibh quis sem varius ultricies. Maecenas egestas justo sed enim maximus consectetur." +
                "Phasellus malesuada magna a ex mollis varius. Quisque a vulputate metus. Cras in nibh lorem. Proin in enim efficitur, pellentesque elit sed, dictum turpis. Duis sagittis lectus eu magna imperdiet maximus. Nullam condimentum scelerisque arcu ac auctor. Phasellus malesuada erat quis gravida mollis.",
            )
        ){ Log.e("CaptureReceipt Configuration Error", it.message.toString())}

        // Initialize the receipt capture system for a user
        CaptureReceipt.initialize("User01", context){ Log.e("CaptureReceipt Initialization Error", it.message.toString())}
    }

    fun company(
        name: String,
        jurisdiction: String,
        privacy: String,
        terms: String
    ) {
        license.company(name, jurisdiction, privacy, terms)
    }


    fun onError(context: Context,message: String){
        AlertDialog.Builder(context)
            .setTitle(null)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .create()
            .show()
    }
}
