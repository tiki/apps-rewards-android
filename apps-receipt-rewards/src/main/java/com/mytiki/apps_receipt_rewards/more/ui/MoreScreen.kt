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
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.ui.more.EstimateCard
import com.mytiki.apps_receipt_rewards.ui.more.MoreAccounts
import com.mytiki.apps_receipt_rewards.ui.more.ProgramDetails
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
        ) { backStackEntry ->
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

                    EstimateCard(moreViewModel.monthlyEarnings.value)

                    Spacer(modifier = Modifier.height(24.dp))

                    MoreAccounts(
                        accountsList = moreViewModel.accountLists.value,
                        alertAccountsList = moreViewModel.alertAccountLists.value
                    ) { accountCommon ->
                        rewardsSharedViewModel.selectAccount(accountCommon)
                        if (accountCommon.accountType == AccountType.EMAIL) {
                            navController.navigate(RewardsRoute.EmailScreen.name)
                        } else {
                            navController.navigate(RewardsRoute.RetailerScreen.name)
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    ProgramDetails(rewardsSharedViewModel, navController, moreViewModel)

                    Spacer(modifier = Modifier.height(56.dp))
                }
            }
        }
    }
}