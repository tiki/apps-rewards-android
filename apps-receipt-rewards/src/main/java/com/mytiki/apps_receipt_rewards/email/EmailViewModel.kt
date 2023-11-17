package com.mytiki.apps_receipt_rewards.email

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.account.AccountStatus

class EmailViewModel() : ViewModel() {
    val accountLists = mutableStateListOf(
        Account(AccountStatus.UNVERIFIED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.LINKED, AccountCommon.GMAIL, "gabrielschuler6@gmail.com"),
    )

    val accountCommon = mutableStateOf(AccountCommon.GMAIL)

    val username = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
}