package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.ui.model.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.model.Account
import com.mytiki.apps_receipt_rewards.ui.model.AccountCommon

class HomeViewModel: ViewModel() {
    var showBottomSheet =  mutableStateOf(true)
    var isExpanded = mutableStateOf(false)
    val chartData = mutableFloatStateOf(4.80f / 12f)
    val  accountLists = mutableStateListOf<Account>(
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL),
        Account(AccountStatus.NOT_LINKED, AccountCommon.WALMART),
        Account(AccountStatus.NOT_LINKED, AccountCommon.UBER_EATS),
        Account(AccountStatus.UNVERIFIED, AccountCommon.TACO_BELL),
        Account(AccountStatus.UNVERIFIED, AccountCommon.UBER_EATS),
        Account(AccountStatus.NOT_LINKED, AccountCommon.DOLLAR_GENERAL),
        Account(AccountStatus.NOT_LINKED, AccountCommon.WALMART),
        Account(AccountStatus.UNVERIFIED, AccountCommon.DOLLAR_GENERAL),
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL),
        Account(AccountStatus.UNVERIFIED, AccountCommon.TACO_BELL),
        Account(AccountStatus.NOT_LINKED, AccountCommon.UBER_EATS),
        Account(AccountStatus.UNVERIFIED, AccountCommon.WALMART),
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL),
        Account(AccountStatus.NOT_LINKED, AccountCommon.TACO_BELL),
        Account(AccountStatus.UNVERIFIED, AccountCommon.WALMART),
        Account(AccountStatus.NOT_LINKED, AccountCommon.DOLLAR_GENERAL),
    )
}
