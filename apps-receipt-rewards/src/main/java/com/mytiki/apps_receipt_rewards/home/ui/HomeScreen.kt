package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.home.HomeViewModel
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheet
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    rewardsSharedViewModel: RewardsSharedViewModel,
    navController: NavHostController,
    onDismissBottomSheet: () -> Unit,
    homeViewModel: HomeViewModel = viewModel(),
) {
    val configuration = LocalConfiguration.current

    val sheetState = rememberModalBottomSheetState {
        homeViewModel.isExpanded.value = it == SheetValue.Expanded
        return@rememberModalBottomSheetState true
    }
    val scope = rememberCoroutineScope()


    fun close() {
        scope.launch { sheetState.hide() }.invokeOnCompletion {
            onDismissBottomSheet()
        }
    }

    fun toAccount(accountProvider: AccountProvider) {
        rewardsSharedViewModel.selectAccount(accountProvider)
        if (accountProvider.accountType == AccountType.EMAIL) {
            navController.navigate(RewardsRoute.EmailScreen.name)
        } else {
            navController.navigate(RewardsRoute.RetailerScreen.name)
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
                slideInVertically(
                    animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy),
                ) togetherWith
                        slideOutVertically(
                            animationSpec = spring(dampingRatio = Spring.DampingRatioNoBouncy),
                        )
            }, label = ""
        ) { targetExpanded ->
            if (targetExpanded) {
                HomeExpanded(homeViewModel) { toAccount(it) }
            } else {
                HomePartiallyExpanded(
                    homeViewModel,
                    { navController.navigate(RewardsRoute.MoreScreen.name) },
                    { toAccount(it) }) { close() }

            }
        }
    }
}



