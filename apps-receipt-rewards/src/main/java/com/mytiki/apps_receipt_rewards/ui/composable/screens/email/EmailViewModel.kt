package com.mytiki.apps_receipt_rewards.ui.composable.screens.email

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.ui.model.Account
import com.mytiki.apps_receipt_rewards.ui.model.AccountCommon
import com.mytiki.apps_receipt_rewards.ui.model.AccountStatus

class EmailViewModel(): ViewModel() {
    val  accountLists = mutableStateListOf<Account>(
        Account(AccountStatus.VERIFIED, AccountCommon.GMAIL, "gabrielschuler3@gmail.com"),
        Account(AccountStatus.UNVERIFIED, AccountCommon.GMAIL, "gabrielschuler6@gmail.com"),
    )

    val email = mutableStateOf<String>("")
    val password = mutableStateOf<String>("")
}