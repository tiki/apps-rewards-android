package com.mytiki.apps_receipt_rewards

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.account.AccountStatus
import com.mytiki.apps_receipt_rewards.home.HomeEarnings
import com.mytiki.apps_receipt_rewards.offer.Offer
import com.mytiki.apps_receipt_rewards.offer.OfferEstimate

object Rewards {

    private var accounts: MutableList<Account> = mutableListOf()
    private var isLicensed: Boolean = false

    /**
     * Start
     *
     * @param context
     */
    fun start(context: Context) {
        val intent = Intent(context, RewardsActivity::class.java)
        context.startActivity(intent)
    }

    /**
     * License
     *
     */
    fun license() {
        isLicensed = true
    }

    /**
     * Decline
     *
     */
    fun decline() {
        isLicensed = false
    }

    /**
     * Estimate
     *
     * @return
     */
    fun estimate(): OfferEstimate {
        return OfferEstimate(5, 15)
    }

    /**
     * Earnings
     *
     * @return
     */
    fun earnings(): HomeEarnings {
        return HomeEarnings(
            34.30,
            4.8,
            12.00
        )
    }

    /**
     * Terms
     *
     * @return
     */
    fun terms(): String {
        return terms
    }

    /**
     * Scan
     *
     * @param context
     */
    fun scan(context: Context){
        Toast.makeText(context, "Receipt scanning functionality not implemented in demo app." , Toast.LENGTH_LONG).show()
    }

    /**
     * Offers
     *
     * @param provider
     * @return
     */
    fun offers(provider: AccountCommon): MutableList<Offer> {
        return mutableListOf<Offer>(
            Offer(provider, "4% cashback on electronics"),
            Offer(provider, "10% off on electronics")
        )
    }

    /**
     * Accounts
     *
     * @return
     */
    fun accounts(): List<Account> {
        return accounts
    }

    /**
     * Available accounts
     *
     * @return
     */
    fun availableAccounts(): List<AccountCommon> {
        val availableAccounts = mutableListOf<AccountCommon>()
        val connectedAccts = accounts()
        for (accountCommon in AccountCommon.values()) {
            if (connectedAccts.find { account ->
                    account.accountCommon == accountCommon
                } == null) {
                availableAccounts.add(accountCommon)
            }
        }
        return availableAccounts
    }

    /**
     * Login
     *
     * @param account
     */
    fun login(account: Account) {
        if (account.username.isNotEmpty() &&
            !account.password.isNullOrEmpty() &&
            accounts.find { connectedAcct ->
                connectedAcct.accountCommon == account.accountCommon &&
                        connectedAcct.username == account.username
            } == null
        ) {
            account.accountStatus = AccountStatus.LINKED
            accounts.add(account)
        }
    }

    /**
     * Logout
     *
     * @param account
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