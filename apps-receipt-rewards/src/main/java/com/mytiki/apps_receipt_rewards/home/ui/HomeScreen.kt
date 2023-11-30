package com.mytiki.apps_receipt_rewards.home.ui

import BottomSheet
import android.content.res.Configuration
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
class HomeScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
    private val onDismiss: () -> Unit
) {

    fun route() {
        navGraphBuilder.composable(
            route = RewardsRoute.HomeScreen.name,
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { configuration.screenWidthDp / 2 },
                    animationSpec = springSpec
                )
            }
        ) {
            val scope = rememberCoroutineScope()
            val sheetState = rememberModalBottomSheetState(true)
            BottomSheet{
                AnimatedContent(
                    targetState = sheetState.hasExpandedState,
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
                        HomeExpanded { accountProvider ->
//                            if (accountProvider.accountType == AccountType.EMAIL) {
//                                navController.navigate(RewardsRoute.EmailView.name)
//                            } else {
//                                navController.navigate(RewardsRoute.RetailerScreen.name)
//                            }
                        }
                    } else {
                        HomeView() {
                            scope.launch {
                                sheetState.hide()
                            }.invokeOnCompletion { onDismiss }
                        }
                    }
                }
            }
        }
    }
}



