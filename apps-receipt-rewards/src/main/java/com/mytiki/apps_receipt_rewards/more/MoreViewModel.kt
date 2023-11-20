package com.mytiki.apps_receipt_rewards.more

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon

class MoreViewModel() : ViewModel() {
    val chartData = mutableListOf(
        MoreContributor(AccountCommon.WALMART.accountName, 0.4f),
        MoreContributor(AccountCommon.TACO_BELL.accountName, 0.3f),
        MoreContributor(AccountCommon.DOLLAR_GENERAL.accountName, 0.2f)
    )

    val accountLists = mutableStateListOf<Account>(
        Account(true, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(true, AccountCommon.WALMART, "gabrielschuler3@gmail.com"),
        Account(true, AccountCommon.DOLLAR_GENERAL, "gabrielschuler3@gmail.com"),
        Account(false, AccountCommon.TACO_BELL, "gabrielschuler3@gmail.com"),
    )
}