package com.mytiki.apps_receipt_rewards.offer.ui

import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheet
import kotlinx.coroutines.launch
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@OptIn(ExperimentalMaterial3Api::class)
class OfferScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
    private val sheetState: SheetState
) {
    fun route(){
        navGraphBuilder.composable(
            route = RewardsRoute.OfferScreen.name,
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
            BottomSheet(
                sheetState,
                modifier = Modifier.requiredHeight(538.dp),
                onDismiss =  {
                    scope.launch {
                        sheetState.hide()
                    }
                },
                content = { OfferContent(navController) }
            )
        }
    }
}