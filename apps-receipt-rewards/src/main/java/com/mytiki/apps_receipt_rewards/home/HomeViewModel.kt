package com.mytiki.apps_receipt_rewards.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider

class HomeViewModel : ViewModel() {
    var showBottomSheet = mutableStateOf(true)
    var isExpanded = mutableStateOf(false)

    val chartData = mutableStateOf(0f)
    val earnings = mutableStateOf<HomeEarnings>(HomeEarnings(0.0, 0.0, 0.0))
    val addAccountList = mutableStateOf<List<AccountProvider>>(listOf())
    val alertAccountList = mutableStateOf<List<AccountProvider>>(listOf())


    init {
        val value = Rewards.earnings()
        earnings.value = value
        chartData.value = (value.monthCurrent / value.monthTotal).toFloat()
        getAccountsLists()
    }

    fun getAccountsLists() {
        val addList = mutableListOf<AccountProvider>()
        val alertList = mutableListOf<AccountProvider>()

        Rewards.accounts().forEach { account ->
            if (!account.isVerified!!) alertList.add(account.accountProvider)
        }
        if (AccountProvider.GMAIL !in alertList) addList.add(AccountProvider.GMAIL)
        addList.addAll(Rewards.uncAccounts())
        addAccountList.value = addList.distinct()
        alertAccountList.value = alertList.distinct()
    }
}
