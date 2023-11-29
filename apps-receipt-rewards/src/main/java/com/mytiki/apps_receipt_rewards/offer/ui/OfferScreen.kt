package com.mytiki.apps_receipt_rewards.offer.ui

import BottomSheet
import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OfferScreen(
    onDismiss: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(true)
    val navController = rememberNavController()

}