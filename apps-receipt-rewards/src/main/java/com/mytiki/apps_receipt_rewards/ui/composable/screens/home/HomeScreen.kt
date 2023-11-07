package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.RewardsChart
import com.mytiki.apps_receipt_rewards.ui.composable.components.bottomSheet.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.components.bottomSheet.BottomSheetHeader
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController, onDismissBottomSheet: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(true)
    val scope = rememberCoroutineScope()
    fun close(){
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismissBottomSheet()
        }
    }
    BottomSheet(
        sheetState = sheetState,
        onDismiss = {
            homeViewModel.showBottomSheet.value = false
            onDismissBottomSheet()
        }
    ) {
        Scaffold (
            topBar = {
                BottomSheetHeader(title = "CASHBACK CONNECTIONS", subTitle = "Share data. Earn cash."){close()}
            },
        ){
            Column(modifier = Modifier.padding(it)){
                RewardsChart(data = homeViewModel.chartData.value, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}