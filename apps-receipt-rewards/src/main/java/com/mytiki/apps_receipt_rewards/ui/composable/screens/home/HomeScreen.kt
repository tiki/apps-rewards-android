 package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
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
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheet
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheetHeader
import kotlinx.coroutines.launch

 @OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class,
     ExperimentalAnimationApi::class
 )
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
        LazyColumn (modifier = Modifier.fillMaxSize()){
            item {
                BottomSheetHeader(
                    title = "CASHBACK CONNECTIONS",
                    subTitle = "Share data. Earn cash."
                ) { close() }
            }
            item {
                HomeContent(homeViewModel, sheetState) {}
                Spacer(modifier = Modifier.height(24.dp))
            }
            item() {
                AnimatedContent(
                    targetState = homeViewModel.isExpanded.value,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(750, 750)) with
                                fadeOut(animationSpec = tween(750)) using
                                SizeTransform { initialSize, targetSize ->
                                    if (targetState) {
                                        keyframes {
                                            // Expand horizontally first.
                                            IntSize(targetSize.width, initialSize.height) at 750
                                            durationMillis = 1500
                                        }
                                    } else {
                                        keyframes {
                                            // Shrink vertically first.
                                            IntSize(initialSize.width, targetSize.height) at 750
                                            durationMillis = 1500
                                        }
                                    }
                                }
                    }, label = ""
                ) { targetExpanded ->
                    if (targetExpanded) {
                        FlowRow(
                            modifier = Modifier.fillMaxSize().padding(horizontal = 40.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            maxItemsInEachRow = 3
                        ) {
                            homeViewModel.retailerList.forEach { retailer ->
                                HomeRetailerItem(retailer, PaddingValues(vertical = 12.dp))
                            }
                        }
                    } else {
                        Column() {
                            LazyRow {
                                items(homeViewModel.retailerList.toList()) { retailer ->
                                    HomeRetailerItem(
                                        retailer,
                                        PaddingValues(horizontal = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



