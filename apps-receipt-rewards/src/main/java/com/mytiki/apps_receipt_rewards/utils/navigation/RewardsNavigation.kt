package com.mytiki.apps_receipt_rewards.utils.navigation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.email.ui.EmailScreen
import com.mytiki.apps_receipt_rewards.home.ui.HomeScreen
import com.mytiki.apps_receipt_rewards.more.ui.MoreScreen
import com.mytiki.apps_receipt_rewards.offer.ui.OfferContent
import com.mytiki.apps_receipt_rewards.offer.ui.OfferScreen
import com.mytiki.apps_receipt_rewards.retailer.RetailerScreen
import com.mytiki.apps_receipt_rewards.terms.TermsScreen
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheet
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RewardsNavigation(
    navController: NavHostController = rememberNavController(),
    onDismissBottomSheet: () -> Unit
) {
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)
    val configuration = LocalConfiguration.current
    val sheetState = rememberModalBottomSheetState(true)

    RewardsTheme(Rewards.colorScheme) {
        NavHost(
            navController = navController,
            startDestination = if (!Rewards.isLicensed){
                RewardsRoute.OfferScreen.name
            } else {
                RewardsRoute.HomeScreen.name
            }
        ) {
            OfferScreen(this, navController, springSpec, configuration, sheetState).route()

            TermsScreen(rewardsSharedViewModel = , navController = )

            composable(
                route = RewardsRoute.HomeScreen.name,
            ) {
                HomeScreen(navController, onDismissBottomSheet)
            }

            composable(
                route = RewardsRoute.EmailScreen.name,
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
            ) { backStackEntry ->
                EmailScreen(navController)
            }

            composable(
                route = RewardsRoute.RetailerScreen.name,
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
            ) { backStackEntry ->
                RetailerScreen(navController)
            }
            composable(
                route = RewardsRoute.MoreScreen.name,
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
            ) { backStackEntry ->
                MoreScreen(navController)
            }
        }
    }
}