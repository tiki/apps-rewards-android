 package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheet
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.home.HomeViewModel
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
         navController.navigate(RewardsRoute.EmailScreen.name)
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



