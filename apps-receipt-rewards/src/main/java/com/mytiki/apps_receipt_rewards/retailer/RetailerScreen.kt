package com.mytiki.apps_receipt_rewards.retailer

import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.ui.AccountCard
import com.mytiki.apps_receipt_rewards.account.ui.AccountDisplay
import com.mytiki.apps_receipt_rewards.offer.ui.OfferCard
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.Input
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

class RetailerScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
) {
    fun route() {
        navGraphBuilder.composable(
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
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp)
                        ) {
                            Spacer(modifier = Modifier.height(64.dp))
                            Header(text = Rewards.currentProvider().accountName) {
                                navController.popBackStack()
                            }
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(28.dp))
                        AccountDisplay(
                            accountCommon,
                            239.dp,
                            "3% cashback on all purchases",
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "Account",
                            modifier = Modifier.padding(horizontal = 21.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                    if (retailerViewModel.accountLists.value.isEmpty()) {
                        item {
                            Spacer(modifier = Modifier.height(24.dp))
                            Input(
                                tile = "Email",
                                text = retailerViewModel.username.value,
                                isShow = true,
                                onChange = { retailerViewModel.username.value = it })
                            Spacer(modifier = Modifier.height(32.dp))
                            Input(
                                tile = "Password",
                                text = retailerViewModel.password.value,
                                isShow = false,
                                onChange = { retailerViewModel.password.value = it })
                            Spacer(modifier = Modifier.height(32.dp))
                            MainButton(
                                modifier = Modifier.padding(horizontal = 21.dp),
                                text = "Sign In",
                                isfFilled = true
                            ) { retailerViewModel.accountLogin(accountCommon) }
                        }
                    } else {
                        items(retailerViewModel.accountLists.value) {
                            Spacer(modifier = Modifier.height(32.dp))
                            AccountCard(it, false) { retailerViewModel.accountLogout(it) }
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(32.dp))
                        MainButton(
                            modifier = Modifier.padding(horizontal = 21.dp),
                            text = "Scan receipt",
                            isfFilled = false
                        ) { retailerViewModel.scanReceipt(context) }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = "More Offers",
                            modifier = Modifier
                                .padding(horizontal = 21.dp)
                                .height(36.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                    }
                    items(retailerViewModel.offerList.value.toList()) {
                        OfferCard(it) { retailerViewModel.openLink(handler, it.offerLink) }
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            }
        }
    }
}