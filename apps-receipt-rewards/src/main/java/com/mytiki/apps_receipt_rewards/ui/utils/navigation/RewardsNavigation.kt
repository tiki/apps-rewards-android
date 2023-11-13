package com.mytiki.apps_receipt_rewards.ui.utils.navigation

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.ui.email.EmailScreen
import com.mytiki.apps_receipt_rewards.ui.email.EmailViewModel
import com.mytiki.apps_receipt_rewards.ui.home.HomeScreen
import com.mytiki.apps_receipt_rewards.ui.home.HomeViewModel
import com.mytiki.apps_receipt_rewards.ui.more.MoreScreen
import com.mytiki.apps_receipt_rewards.ui.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.ui.offer.OfferScreen
import com.mytiki.apps_receipt_rewards.ui.offer.OfferViewModel
import com.mytiki.apps_receipt_rewards.ui.retailer.RetailerScreen
import com.mytiki.apps_receipt_rewards.ui.retailer.RetailerViewModel
import com.mytiki.apps_receipt_rewards.ui.terms.TermsScreen
import com.mytiki.apps_receipt_rewards.ui.terms.TermsViewModel

@Composable
fun RewardsNavigation(
    offerViewModel: OfferViewModel = viewModel(),
    termsViewModel: TermsViewModel = viewModel(),
    homeViewModel: HomeViewModel = viewModel(),
    emailViewModel: EmailViewModel = viewModel(),
    retailerViewModel: RetailerViewModel = viewModel(),
    moreViewModel: MoreViewModel = viewModel(),
    onDismissBottomSheet: () -> Unit
){
    val navController = rememberNavController()
    val fadeSpec: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessVeryLow)
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)
    val configuration = LocalConfiguration.current

    NavHost(
        navController = navController,
        startDestination = RewardsRoute.MoreScreen.name
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

        composable(
            route = RewardsRoute.HomeScreen.name,
        ){
            HomeScreen(homeViewModel, navController, onDismissBottomSheet)
        }

        composable(
            route = RewardsRoute.EmailScreen.name,
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
        ){backStackEntry ->
            EmailScreen(emailViewModel, navController)
        }

        composable(
            route = RewardsRoute.RetailerScreen.name,
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
        ){backStackEntry ->
            RetailerScreen(retailerViewModel, navController)
        }
        composable(
            route = RewardsRoute.MoreScreen.name,
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
        ){backStackEntry ->
            MoreScreen(moreViewModel, navController)
        }
    }
}