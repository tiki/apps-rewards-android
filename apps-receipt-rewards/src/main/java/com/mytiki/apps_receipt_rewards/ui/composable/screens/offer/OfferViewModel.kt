package com.mytiki.apps_receipt_rewards.ui.composable.screens.offer

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OfferViewModel(): ViewModel(){
    var showBottomSheet =  mutableStateOf(true)
}
