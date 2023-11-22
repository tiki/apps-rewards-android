package com.mytiki.apps_receipt_rewards.ui

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider

class RewardsSharedViewModel : ViewModel() {

    val colorScheme = mutableStateOf(lightColorScheme())

    val isLicensed = mutableStateOf(false)

    val selectedAccount = mutableStateOf<AccountProvider>(AccountProvider.GMAIL)

    init {
        isLicensed.value = Rewards.isLicensed
        colorScheme.value = Rewards.colorScheme
    }

    fun createLicense() {
        isLicensed.value = true
        Rewards.createLicense()
    }

    fun declineLicense() {
        isLicensed.value = false
        Rewards.decline()
    }

    fun selectAccount(accountProvider: AccountProvider) {
        selectedAccount.value = accountProvider
    }
}