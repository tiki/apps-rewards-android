//package com.mytiki.apps_receipt_rewards.utils.navigation
//
//import androidx.compose.animation.core.Spring
//import androidx.compose.animation.core.spring
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.LocalConfiguration
//import androidx.compose.ui.unit.IntOffset
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.rememberNavController
//import com.mytiki.apps_receipt_rewards.Rewards
//import com.mytiki.apps_receipt_rewards.email.ui.EmailView
//import com.mytiki.apps_receipt_rewards.home.ui.HomeScreen
//import com.mytiki.apps_receipt_rewards.more.ui.MoreScreen
//import com.mytiki.apps_receipt_rewards.terms.OfferTermsScreen
//import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun RewardsNavigation(onDismiss: () -> Unit) {
//    val navController: NavHostController = rememberNavController()
//    val springSpec = spring<IntOffset>(dampingRatio = Spring.DampingRatioNoBouncy)
//    val configuration = LocalConfiguration.current
//
//    RewardsTheme(Rewards.colorScheme) {
//        NavHost(
//            navController = navController,
//            startDestination = if (!Rewards.isLicensed) {
//                RewardsRoute.OfferScreen.name
//            } else {
//                RewardsRoute.HomeScreen.name
//            }
//        ) {
//            OfferTermsScreen(this, navController, springSpec, configuration).route()
//            HomeScreen(this, navController, springSpec, configuration) { onDismiss() }.route()
//            RetailerScreen(this, navController, springSpec, configuration).route()
//            EmailView(this, navController, springSpec, configuration).route()
//            MoreScreen(this, navController, springSpec, configuration).route()
//        }
//    }
//}