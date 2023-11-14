package com.mytiki.apps_receipt_rewards.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.account.AccountStatus
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon

class HomeViewModel: ViewModel() {
    var showBottomSheet =  mutableStateOf(true)
    var isExpanded = mutableStateOf(false)
    val chartData = mutableStateListOf(4.80f / 12f)
    val  accountLists = mutableStateListOf<Account>(
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.UBER_EATS, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.TACO_BELL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.UBER_EATS, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.DOLLAR_GENERAL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.DOLLAR_GENERAL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.TACO_BELL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.UBER_EATS, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.TACO_BELL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.NOT_LINKED, AccountCommon.DOLLAR_GENERAL, "gabrielschuler3@gmail.com"),
    )
}
