package com.mytiki.apps_receipt_rewards.offer

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mytiki.apps_receipt_rewards.ui.RewardsViewModel

class OfferViewModel() : ViewModel() {

    var showBottomSheet = mutableStateOf(true)
}
