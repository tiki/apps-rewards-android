package com.mytiki.apps_receipt_rewards.ui.composable.navigation

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.ui.composable.screens.offer.OfferScreen
import com.mytiki.apps_receipt_rewards.ui.composable.screens.offer.OfferViewModel
import com.mytiki.apps_receipt_rewards.ui.composable.screens.terms.TermsScreen
import com.mytiki.apps_receipt_rewards.ui.composable.screens.terms.TermsViewModel

@Composable
fun RewardsNavigation(
    offerViewModel: OfferViewModel = viewModel(),
    termsViewModel: TermsViewModel = viewModel(),
    onDismissBottomSheet: () -> Unit ){
    val navController = rememberNavController()
    val fadeSpec: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessVeryLow)
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)
    val configuration = LocalConfiguration.current

    NavHost(
        navController = navController,
        startDestination = RewardsRoute.OfferScreen.name
    ){
        composable(
            route = RewardsRoute.OfferScreen.name,
        ){
            OfferScreen(offerViewModel, navController, onDismissBottomSheet)
        }

        composable(
            route = RewardsRoute.TermsScreen.name,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { configuration.screenWidthDp/2 }, animationSpec = springSpec)
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -configuration.screenWidthDp/2 }, animationSpec = springSpec)
            },
            popEnterTransition = {
                slideInHorizontally(initialOffsetX = { -configuration.screenWidthDp/2 }, animationSpec = springSpec)
            },
            popExitTransition = {
                slideOutHorizontally(targetOffsetX = { configuration.screenWidthDp/2 }, animationSpec = springSpec)
            }
        ){
            TermsScreen(termsViewModel, navController)
        }
    }
}