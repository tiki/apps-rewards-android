package com.mytiki.apps_receipt_rewards.more

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon

class MoreViewModel() : ViewModel() {
    val monthlyEarnings = mutableStateOf<List<MoreContributor>>(listOf())
    val accountLists = mutableStateOf<List<AccountCommon>>(listOf())
    val alertAccountLists = mutableStateOf<List<AccountCommon>>(listOf())

    init {
        getAccountsList()
        getMonthlyEarnings()
    }

    fun getAccountsList(){
        val accounts = mutableListOf<AccountCommon>()
        val alertAccounts = mutableListOf<AccountCommon>()

        Rewards.accounts().forEach{
            if(it.isVerified == true) accounts.add(it.accountCommon) else alertAccounts.add(it.accountCommon)
        }

        accountLists.value = accounts.distinct().filter { it !in  alertAccounts.distinct()}
        alertAccountLists.value = alertAccounts.distinct()
    }

    fun getMonthlyEarnings(){
        monthlyEarnings.value = Rewards.monthlyEarnings().sortedByDescending { it.percentage }
    }

    fun openLink(handler: UriHandler){
        handler.openUri("https://www.google.com")
    }
}