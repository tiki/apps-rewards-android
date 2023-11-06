package com.mytiki.apps_receipt_rewards.ui.composable.navigation

import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.ui.activities.RewardsActivity
import com.mytiki.apps_receipt_rewards.ui.composable.screens.offer.OfferScreen
import com.mytiki.apps_receipt_rewards.ui.composable.screens.offer.OfferViewModel

@Composable
fun RewardsNavigation(offerViewModel: OfferViewModel = viewModel(), onDismissBottomSheet: () -> Unit ){
    val navController = rememberNavController()
    val fadeSpec: FiniteAnimationSpec<Float> = spring(stiffness = Spring.StiffnessVeryLow)
    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)

    NavHost(
        navController = navController,
        startDestination = RewardsRoute.OfferScreen.name
    ){
        composable(
            route = RewardsRoute.OfferScreen.name,
        ){
            OfferScreen(offerViewModel, navController, onDismissBottomSheet)
        }
    }
}