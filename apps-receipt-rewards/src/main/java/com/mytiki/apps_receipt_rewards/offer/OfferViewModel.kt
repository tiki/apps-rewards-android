package com.mytiki.apps_receipt_rewards.offer

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async

@OptIn(ExperimentalMaterial3Api::class)
class OfferViewModel(): ViewModel(){
    var showBottomSheet =  mutableStateOf(true)
}
