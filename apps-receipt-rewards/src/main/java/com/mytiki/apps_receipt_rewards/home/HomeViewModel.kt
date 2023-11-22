package com.mytiki.apps_receipt_rewards.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon

class HomeViewModel() : ViewModel() {
    var showBottomSheet = mutableStateOf(true)
    var isExpanded = mutableStateOf(false)

    val chartData = mutableStateOf(0f)
    val earnings = mutableStateOf<HomeEarnings>(HomeEarnings(0.0,0.0, 0.0))
    val addAccountList = mutableStateOf<List<AccountCommon>>(listOf())
    val alertAccountList = mutableStateOf<List<AccountCommon>>(listOf())


    init {
        val value = Rewards.earnings()
        earnings.value = value
        chartData.value = (value.monthCurrent / value.monthTotal).toFloat()
        getAccountsLists()
    }

    fun getAccountsLists(){
        val addList = mutableListOf<AccountCommon>()
        val alertList = mutableListOf<AccountCommon>()

        Rewards.accounts().forEach{account ->
            if (!account.isVerified!!) alertList.add(account.accountCommon)
        }
        if (AccountCommon.GMAIL !in alertList) addList.add(AccountCommon.GMAIL)
        addList.addAll(Rewards.uncAccounts())
        addAccountList.value = addList.distinct()
        alertAccountList.value = alertList.distinct()
    }
}
