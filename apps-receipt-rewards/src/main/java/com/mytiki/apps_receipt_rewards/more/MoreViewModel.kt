package com.mytiki.apps_receipt_rewards.more

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.account.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.RewardsViewModel

class MoreViewModel() : ViewModel() {
    val chartData = mutableStateMapOf(
        AccountCommon.WALMART.accountName to 0.4f,
        AccountCommon.TACO_BELL.accountName to 0.3f,
        AccountCommon.DOLLAR_GENERAL.accountName to 0.2f
    )

    val accountLists = mutableStateListOf<Account>(
        Account(AccountStatus.LINKED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.LINKED, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.LINKED, AccountCommon.DOLLAR_GENERAL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.TACO_BELL, "gabrielschuler3@gmail.com"),
    )
}