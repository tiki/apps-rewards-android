package com.mytiki.apps_receipt_rewards.retailer

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.UriHandler
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.offer.Offer

class RetailerViewModel : ViewModel() {
    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
    val accountLists = mutableStateOf<List<Account>>(listOf())
    val offerList = mutableStateOf<List<Offer>>(listOf())

    fun getAccountList(accountProvider: AccountProvider) {
        accountLists.value = Rewards.accounts(accountProvider)
    }

    fun getOffers(accountProvider: AccountProvider) {
        offerList.value = Rewards.offers(accountProvider)
    }

    fun scanReceipt(context: Context) {
        Rewards.scan(context)
    }

    fun accountLogin(accountProvider: AccountProvider) {
        Rewards.login(
            Account(null, accountProvider, username.value, password.value)
        )
        getAccountList(accountProvider)
    }

    fun accountLogout(account: Account) {
        Rewards.logout(account)
        getAccountList(account.accountProvider)
    }

    fun openLink(handler: UriHandler, uri: String) {
        handler.openUri(uri)
    }
}