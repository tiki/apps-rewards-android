 package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheetHeader
import kotlinx.coroutines.launch

 @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController, onDismissBottomSheet: () -> Unit) {
    val sheetState = rememberModalBottomSheetState(false){
        homeViewModel.isExpanded.value = it == SheetValue.Expanded
        return@rememberModalBottomSheetState true
    }
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
        if (homeViewModel.isExpanded.value){
            LazyColumn{
                item {
                    BottomSheetHeader(title = "CASHBACK CONNECTIONS", subTitle = "Share data. Earn cash."){close()}
                }
                item {
                    HomeContent(homeViewModel, sheetState){}
                }
                item() {
                    Spacer(modifier = Modifier.height(12.dp))
                    FlowRow(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 40.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        maxItemsInEachRow = 3
                    ) {
                        homeViewModel.retailerList.forEach { retailer ->
                            HomeRetailerItem(retailer, PaddingValues(vertical = 12.dp))
                        }
                    }
                }
            }

        } else {
            Scaffold (
                topBar = {
                    BottomSheetHeader(title = "CASHBACK CONNECTIONS", subTitle = "Share data. Earn cash."){close()}
                },
            ){
                Column(modifier = Modifier.padding(it)) {
                    HomeContent(homeViewModel, sheetState){}
                    Spacer(modifier = Modifier.height(24.dp))
                    LazyRow {
                        items(homeViewModel.retailerList.toList()) { retailer ->
                            HomeRetailerItem(retailer, PaddingValues(horizontal = 10.dp))
                        }
                    }
                }
            }
        }
    }
}



