package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    var showBottomSheet =  mutableStateOf(true)
    val chartData = mutableFloatStateOf(120f)
}
