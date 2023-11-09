 package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
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
import androidx.compose.ui.platform.LocalConfiguration
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
     val configuration = LocalConfiguration.current

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
     fun toAccount(account: Account){
         if (account.accountCommon.accountType == AccountType.EMAIL){
             navController.navigate("${RewardsRoute.EmailScreen.name}/${account.toJson()}")
         } else {
             navController.navigate("${RewardsRoute.EmailScreen.name}/${account.toJson()}")
         }

     }


    BottomSheet(
        sheetState = sheetState,
        onDismiss = {
            homeViewModel.showBottomSheet.value = false
            onDismissBottomSheet()
        }
    ) {

        AnimatedContent(
            targetState = homeViewModel.isExpanded.value,
            transitionSpec = {
                slideInVertically(initialOffsetY = { configuration.screenHeightDp/2  }, animationSpec = tween(750,750)) togetherWith
                        slideOutVertically( targetOffsetY = { -configuration.screenHeightDp/2 }, animationSpec = tween(750, 750))
            }, label = ""
        ) { targetExpanded ->
            if (targetExpanded) {
                HomeExpanded(homeViewModel) { toAccount(it) }
            } else {
                HomePartiallyExpanded(homeViewModel, { toAccount(it) }) { close() }

            }
        }

    }
}



