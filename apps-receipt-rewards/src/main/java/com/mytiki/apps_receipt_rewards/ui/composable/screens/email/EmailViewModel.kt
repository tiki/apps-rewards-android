package com.mytiki.apps_receipt_rewards.ui.composable.screens.email

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.ui.model.account.Account
import com.mytiki.apps_receipt_rewards.ui.model.account.AccountCommon
import com.mytiki.apps_receipt_rewards.ui.model.account.AccountStatus

class EmailViewModel(): ViewModel() {
    val  accountLists = mutableStateListOf(
        Account(AccountStatus.UNVERIFIED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.VERIFIED, AccountCommon.GMAIL, "gabrielschuler6@gmail.com"),
    )

    val  accountCommon = mutableStateOf(AccountCommon.WALMART)

    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
}