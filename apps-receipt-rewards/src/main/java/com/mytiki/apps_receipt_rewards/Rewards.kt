package com.mytiki.apps_receipt_rewards

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.home.HomeEarnings
import com.mytiki.apps_receipt_rewards.offer.Offer
import com.mytiki.apps_receipt_rewards.offer.OfferEstimate
import com.mytiki.apps_receipt_rewards.utils.theme.Black
import com.mytiki.apps_receipt_rewards.utils.theme.DarkGray
import com.mytiki.apps_receipt_rewards.utils.theme.Green
import com.mytiki.apps_receipt_rewards.utils.theme.Red
import com.mytiki.apps_receipt_rewards.utils.theme.White

/**
 * This object provides functionalities and information related to rewards and accounts.
 */
object Rewards {

    private var accounts: MutableList<Account> = mutableListOf(
        Account(true, AccountCommon.GMAIL, "email1@gmail.com"),
        Account(false, AccountCommon.WALMART, "email@gmail.com"),
        Account(true, AccountCommon.UBER_EATS, "email@gmail.com"),
        Account(false, AccountCommon.TACO_BELL, "email@gmail.com"),
        Account(true, AccountCommon.UBER_EATS, "email@gmail.com"),
        Account(false, AccountCommon.GMAIL, "email2@gmail.com"),

    )
    var isLicensed: Boolean = false
        private set
    var colorScheme: ColorScheme = lightColorScheme(
        primary = Color(0xFF00B272),
        error = Color(0xFFC73000),
        background = Color(0xFFFFFFFF),
        onBackground = Color(0x15000000),
        outline = Color(0xFF000000),
        outlineVariant = Color(0x99000000),
    )
        private set


    /**
     * Starts the Rewards activity.
     *
     * @param context The context used to start the RewardsActivity.
     */
    fun start(
        context: Context,
        primaryTextColor: Color = Color(0xFF000000),
        secondaryTextColor: Color = Color(0x99000000),
        primaryBackgroundColor: Color = Color(0xFFFFFFFF),
        secondaryBackgroundColor: Color = Color(0x15000000),
        accentColor: Color = Color(0xFF00B272)
    ) {
        colorScheme = lightColorScheme(
            primary = accentColor,
            error = Color(0xFFC73000),
            background = primaryBackgroundColor,
            onBackground = secondaryBackgroundColor,
            outline = primaryTextColor,
            outlineVariant = secondaryTextColor,
        )
        this.fontFamily = fontFamily
        isLicensed = checkLicense()
        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)
    }

    /**
     * check if there is a valid license for the user
     */
    fun checkLicense(): Boolean{
        return true
    }

    /**
     * Grants a license.
     */
    fun createLicense() {
        isLicensed = true
    }

    /**
     * Declines a license.
     */
    fun declineLicense() {
        isLicensed = false
    }

    /**
     * Provides an estimate of an offer.
     *
     * @return The estimated offer.
     */
    fun estimate(): OfferEstimate {
        return OfferEstimate(10, 25)
    }

    /**
     * Retrieves the earnings details.
     *
     * @return The earnings details.
     */
    fun earnings(): HomeEarnings {
        return HomeEarnings(
            34.30,
            4.8,
            12.00
        )
    }

    /**
     * Retrieves the terms and conditions.
     *
     * @return The terms and conditions.
     */
    fun terms(): String {
        return terms
    }

    /**
     * Scans receipts.
     *
     * @param context The context used for scanning.
     */
    fun scan(context: Context) {
        Toast.makeText(
            context,
            "Receipt scanning functionality not implemented in demo app.",
            Toast.LENGTH_LONG
        ).show()
    }

    /**
     * Retrieves a list of offers for a given account provider.
     *
     * @param provider The account provider.
     * @return A list of offers for the provider.
     */
    fun offers(provider: AccountCommon): List<Offer> {
        return listOf(
            Offer(provider, "4% cashback on electronics"),
            Offer(provider, "10% off on electronics")
        )
    }

    /**
     * Retrieves a list of accounts.
     *
     * @return A list of accounts.
     */
    fun accounts(): List<Account> {
        return accounts
    }

    /**
     * Retrieves a list of accounts.
     *
     * @return A list of accounts.
     */
    fun accounts(accountCommon: AccountCommon): List<Account> {
        return accounts().filter{it.accountCommon == accountCommon}
    }

    /**
     * Retrieves a list of available accounts.
     *
     * @return A list of available accounts.
     */
    fun uncAccounts(): List<AccountCommon> {
        val uncAccounts = mutableListOf<AccountCommon>()
        val connectedAccounts = accounts()
        for (accountCommon in AccountCommon.values()) {
            if (connectedAccounts.find { account ->
                    account.accountCommon == accountCommon
                } == null) {
                uncAccounts.add(accountCommon)
            }
        }
        return uncAccounts
    }

    /**
     * Logs in to an account.
     *
     * @param account The account to log in.
     */
    fun login(account: Account) {
        if (account.username.isNotEmpty() &&
            !account.password.isNullOrEmpty() &&
            accounts.find { connectedAcct ->
                connectedAcct.accountCommon == account.accountCommon &&
                        connectedAcct.username == account.username
            } == null
        ) {
            account.isVerified = true
            accounts.add(account)
        }
    }

    /**
     * Logs out from an account.
     *
     * @param account The account to log out.
     */
    fun logout(account: Account) {
        if (account.username.isNotEmpty()) {
            val connectedAccount = accounts.find { connectedAcct ->
                connectedAcct.accountCommon == account.accountCommon &&
                        connectedAcct.username == account.username
            }
            if (connectedAccount != null) {
                accounts.remove(connectedAccount)
            }
        }
    }

    private const val terms =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus lobortis risus ac ultrices faucibus. Nullam vel pulvinar neque. Morbi ultrices maximus est, quis blandit urna vestibulum nec. Morbi et finibus nisi. Vestibulum dignissim rutrum mi sit amet sagittis. Aenean id ligula eget enim feugiat luctus vitae vitae orci. Maecenas aliquam semper nunc vel pellentesque. Ut cursus neque non est mattis consequat. Duis posuere odio et tellus aliquam, et tristique erat pharetra. Mauris sollicitudin lorem ligula. Ut lacinia, neque ac ornare gravida, libero turpis fermentum nibh, eget sodales diam magna sit amet lacus. Aliquam pretium suscipit mi eget luctus. Aliquam ut velit ut magna elementum sollicitudin in et magna. Ut a elementum tellus, eu cursus lacus. Pellentesque neque nisi, semper ac mi vel, fringilla semper nisl. Morbi at vulputate lectus, non ornare nulla." +
                "Vestibulum convallis rutrum tellus sed vulputate. Suspendisse condimentum mauris quis odio aliquet, at posuere augue egestas. Nulla finibus nibh ac placerat pretium. Mauris volutpat urna sit amet vehicula fermentum. Praesent semper est diam, sit amet elementum orci luctus ac. Quisque condimentum ipsum in venenatis rutrum. Donec rutrum nisl id elit porttitor, vel scelerisque quam ultricies. Donec vulputate, mi at tempor hendrerit, risus tortor consequat neque, non laoreet orci ante tempor dolor. Curabitur placerat convallis risus, a facilisis diam mollis in." +
                "Mauris in ex dolor. Nunc eu mollis mi. Integer ut nulla egestas, finibus tellus in, congue sem. Vestibulum sit amet velit cursus, consequat purus id, porttitor ligula. Aliquam pellentesque non augue quis tincidunt. Duis a pulvinar odio, non ultrices metus. Sed eu risus quam. Nam vehicula ligula id aliquet aliquet. Quisque faucibus odio pulvinar tellus tristique, eget tempus tellus accumsan. Nulla vehicula nunc quis dapibus lobortis. Sed urna magna, commodo vitae enim eget, scelerisque hendrerit mi. Pellentesque lobortis lectus vitae convallis facilisis." +
                "Phasellus lobortis purus sit amet sodales efficitur. Mauris sapien lorem, pretium id turpis eu, tristique maximus tellus. Donec porttitor, enim ut scelerisque dapibus, lectus tellus laoreet ante, a ornare dolor nisi sed risus. Vestibulum facilisis mollis urna in suscipit. Pellentesque sit amet lobortis nulla. Fusce semper rhoncus urna a gravida. In congue nec nisi eu hendrerit. Donec sed felis elementum lacus posuere porttitor eget quis dolor. Maecenas eu iaculis dolor. Nam venenatis tempor velit vel finibus. Phasellus purus nunc, condimentum sit amet porttitor nec, rhoncus et ante. Fusce tristique nibh quis sem varius ultricies. Maecenas egestas justo sed enim maximus consectetur." +
                "Phasellus malesuada magna a ex mollis varius. Quisque a vulputate metus. Cras in nibh lorem. Proin in enim efficitur, pellentesque elit sed, dictum turpis. Duis sagittis lectus eu magna imperdiet maximus. Nullam condimentum scelerisque arcu ac auctor. Phasellus malesuada erat quis gravida mollis."

}