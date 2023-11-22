package com.mytiki.apps_receipt_rewards.more.ui

import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.ui.more.EstimateCard
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

class MoreScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
) {

    fun route() {
        navGraphBuilder.composable(
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
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    Box(modifier = Modifier.padding(horizontal = 21.dp)) {
                        Header(text = "BACK") {
                            navController.popBackStack()
                        }
                    }

                    Spacer(modifier = Modifier.height(34.dp))

                    EstimateCard(Rewards.monthlyEarnings())

                    Spacer(modifier = Modifier.height(24.dp))

                    MoreAccounts(
                        accountsList = Rewards.accounts().map { account -> account.accountProvider },
                    ) { provider ->
                        if (provider.accountType == AccountType.EMAIL) {
                            navController.navigate(RewardsRoute.EmailScreen.name)
                        } else {
                            navController.navigate(RewardsRoute.RetailerScreen.name)
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    ProgramDetails( navController )

                    Spacer(modifier = Modifier.height(56.dp))
                }
            }
        }
    }
}