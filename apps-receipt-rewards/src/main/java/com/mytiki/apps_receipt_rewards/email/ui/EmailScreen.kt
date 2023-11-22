package com.mytiki.apps_receipt_rewards.email.ui

import android.content.res.Configuration
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.ui.AccountCard
import com.mytiki.apps_receipt_rewards.account.ui.AccountDisplay
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.LoginForm
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@OptIn(ExperimentalLayoutApi::class)

class EmailScreen(
    private val navGraphBuilder: NavGraphBuilder,
    private val navController: NavController,
    private val springSpec: SpringSpec<IntOffset>,
    private val configuration: Configuration,
) {
    fun route() {
        navGraphBuilder.composable(
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
                            Header(text = Rewards.currentProvider.accountName) {
                                navController.popBackStack()
                            }
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.height(28.dp))
                        AccountDisplay(
                            Rewards.currentProvider,
                            275.dp,
                            "When you connect your Gmail account, we auto-identify receipts and process available cashback rewards",
                        )
                    }
                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = "Accounts",
                            modifier = Modifier.padding(horizontal = 21.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                    val accounts = Rewards.accounts(Rewards.currentProvider)

                    items(accounts) {
                        Spacer(modifier = Modifier.height(32.dp))
                        AccountCard(it, false) { Rewards.logout(it) }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    item {
                        Spacer(modifier = Modifier.height(38.dp))
                        Text(
                            text = "Add Account",
                            modifier = Modifier.padding(horizontal = 21.dp),
                            style = MaterialTheme.typography.headlineLarge
                        )
                        Spacer(modifier = Modifier.height(46.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            GoogleSignIn { }
                        }
                        Spacer(modifier = Modifier.height(38.dp))
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 21.dp)
                                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .height(1.dp)
                                    .weight(1f)
                                    .background(MaterialTheme.colorScheme.outlineVariant)
                            ) {}
                            Text(
                                text = "or",
                                modifier = Modifier.padding(horizontal = 15.dp),
                                style = MaterialTheme.typography.displaySmall,
                                textAlign = TextAlign.Center
                            )
                            Box(
                                modifier = Modifier
                                    .height(1.dp)
                                    .weight(1f)
                                    .background(MaterialTheme.colorScheme.outlineVariant)
                            ) {}
                        }
                        Spacer(modifier = Modifier.height(32.dp))

                        LoginForm()

                    }
                }
            }
        }
    }
}