package com.mytiki.apps_receipt_rewards.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RewardsSharedViewModel(): ViewModel() {
    private val _isLicensed = MutableStateFlow<Boolean>(false)
    val isLicensed = _isLicensed.asStateFlow()

    init {
        _isLicensed.value = Rewards.getIsLicensed()
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