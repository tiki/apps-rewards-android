package com.mytiki.apps_receipt_rewards.offer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel

class OfferViewModel() : ViewModel() {

    var showBottomSheet = mutableStateOf(true)

    fun getEstimate(): OfferEstimate {
        return Rewards.estimate()
    }
}
