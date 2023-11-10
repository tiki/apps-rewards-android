package com.mytiki.apps_receipt_rewards.ui.composable.screens.more

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MoreViewModel(): ViewModel() {
    val chartData = mutableStateListOf(0.3f, 0.5f, 0.7f)
}