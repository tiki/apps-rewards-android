package com.mytiki.apps_receipt_rewards.more

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.UriHandler
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider

class MoreViewModel : ViewModel() {
    val monthlyEarnings = mutableStateOf<List<MoreContributor>>(listOf())
    val accountLists = mutableStateOf<List<AccountProvider>>(listOf())
    val alertAccountLists = mutableStateOf<List<AccountProvider>>(listOf())

    init {
        getAccountsList()
        getMonthlyEarnings()
    }

    fun getAccountsList() {
        val accounts = mutableListOf<AccountProvider>()
        val alertAccounts = mutableListOf<AccountProvider>()

        Rewards.accounts().forEach {
            if (it.isVerified == true) accounts.add(it.accountProvider) else alertAccounts.add(it.accountProvider)
        }

        accountLists.value = accounts.distinct().filter { it !in alertAccounts.distinct() }
        alertAccountLists.value = alertAccounts.distinct()
    }

    fun getMonthlyEarnings() {
        monthlyEarnings.value = Rewards.monthlyEarnings().sortedByDescending { it.percentage }
    }

    fun openLink(handler: UriHandler) {
        handler.openUri("https://www.google.com")
    }
}