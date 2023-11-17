package com.mytiki.apps_receipt_rewards.utils.navigation

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.email.EmailViewModel
import com.mytiki.apps_receipt_rewards.email.ui.EmailScreen
import com.mytiki.apps_receipt_rewards.home.HomeViewModel
import com.mytiki.apps_receipt_rewards.home.ui.HomeScreen
import com.mytiki.apps_receipt_rewards.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.more.ui.MoreScreen
import com.mytiki.apps_receipt_rewards.offer.OfferViewModel
import com.mytiki.apps_receipt_rewards.offer.ui.OfferScreen
import com.mytiki.apps_receipt_rewards.retailer.RetailerScreen
import com.mytiki.apps_receipt_rewards.retailer.RetailerViewModel
import com.mytiki.apps_receipt_rewards.terms.TermsScreen
import com.mytiki.apps_receipt_rewards.terms.TermsViewModel
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme

@Composable
fun RewardsNavigation(
    navController: NavHostController = rememberNavController(),
    onDismissBottomSheet: () -> Unit
) {
    val fadeSpec: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessVeryLow)
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)
    val configuration = LocalConfiguration.current

    val rewardsSharedViewModel: RewardsSharedViewModel = viewModel()
    RewardsTheme (rewardsSharedViewModel.colorScheme.value){
        NavHost(
            navController = navController,
            startDestination = if (!rewardsSharedViewModel.isLicensed.collectAsState().value) RewardsRoute.OfferScreen.name else RewardsRoute.HomeScreen.name
        ) {

            composable(
                route = RewardsRoute.OfferScreen.name,
            ) {
                OfferScreen(rewardsSharedViewModel, navController, onDismissBottomSheet)
            }

            composable(
                route = RewardsRoute.TermsScreen.name,
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
                TermsScreen(rewardsSharedViewModel, navController)
            }

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