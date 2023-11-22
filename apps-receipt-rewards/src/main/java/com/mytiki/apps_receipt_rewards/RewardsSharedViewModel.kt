package com.mytiki.apps_receipt_rewards.ui

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RewardsSharedViewModel(): ViewModel() {

    val colorScheme = mutableStateOf(lightColorScheme())

    private val _isLicensed = MutableStateFlow(false)
    val isLicensed = _isLicensed.asStateFlow()

    init {
        _isLicensed.value = Rewards.isLicensed
        colorScheme.value = Rewards.colorScheme
    }

    fun acceptLicense() {
        _isLicensed.value = true
        Rewards.license()
    }

    fun declineLicense() {
        _isLicensed.value = false
        Rewards.decline()
    }
}