package com.mytiki.apps_receipt_rewards.ui

import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RewardsSharedViewModel(): ViewModel() {

    val colorScheme = mutableStateOf(lightColorScheme())

    val isLicensed = mutableStateOf(false)

    val selectedAccount = mutableStateOf<AccountCommon>(AccountCommon.GMAIL)

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
        Rewards.declineLicense()
    }

    fun selectAccount(accountCommon: AccountCommon){
        selectedAccount.value = accountCommon
    }
}