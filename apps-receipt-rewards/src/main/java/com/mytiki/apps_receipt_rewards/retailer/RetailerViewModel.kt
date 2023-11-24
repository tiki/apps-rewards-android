package com.mytiki.apps_receipt_rewards.retailer

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.UriHandler
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.offer.Offer

class RetailerViewModel() : ViewModel() {
    val  accountLists = mutableStateListOf<Account>()
    val accountCommon = mutableStateOf(AccountCommon.WALMART)

    val offerLists = mutableStateListOf<Offer>(
        Offer(AccountCommon.WALMART, "4% cashback on electronics"),
        Offer(AccountCommon.WALMART, "4% cashback on electronics"),
    )
    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
    val accountLists = mutableStateOf<List<Account>>(listOf())
    val offerList = mutableStateOf<List<Offer>>(listOf())

    fun getAccountList(accountCommon: AccountCommon){
        accountLists.value = Rewards.accounts(accountCommon)
    }
    fun getOffers(accountCommon: AccountCommon){
        offerList.value = Rewards.offers(accountCommon)
    }
    fun scanReceipt(context: Context){
        Rewards.scan(context)
    }
    fun accountLogin(accountCommon: AccountCommon){
        Rewards.login(
            Account(null,accountCommon,username.value,password.value)
        )
        getAccountList(accountCommon)
    }
    fun accountLogout(account: Account){
        Rewards.logout(account)
        getAccountList(account.accountCommon)
    }

    fun openLink(handler: UriHandler, uri: String){
        handler.openUri(uri)
    }
}