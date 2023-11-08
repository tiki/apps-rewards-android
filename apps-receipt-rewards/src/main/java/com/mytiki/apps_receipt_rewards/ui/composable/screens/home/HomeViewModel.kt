package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.ui.model.AccountStatus
import com.mytiki.apps_receipt_rewards.ui.model.Retailer
import com.mytiki.apps_receipt_rewards.ui.model.RetailerCommon

class HomeViewModel: ViewModel() {
    var showBottomSheet =  mutableStateOf(true)
    var isExpanded = mutableStateOf(false)
    val chartData = mutableFloatStateOf(4.80f / 12f)
    val  retailerList = mutableStateListOf<Retailer>(
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.GMAIL),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.WALMART),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.UBER_EATS),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.TACO_BELL),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.UBER_EATS),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.DOLLAR_GENERAL),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.WALMART),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.DOLLAR_GENERAL),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.GMAIL),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.TACO_BELL),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.UBER_EATS),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.WALMART),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.GMAIL),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.TACO_BELL),
        Retailer(AccountStatus.UNVERIFIED, RetailerCommon.WALMART),
        Retailer(AccountStatus.NOT_LINKED, RetailerCommon.DOLLAR_GENERAL),
    )
}
