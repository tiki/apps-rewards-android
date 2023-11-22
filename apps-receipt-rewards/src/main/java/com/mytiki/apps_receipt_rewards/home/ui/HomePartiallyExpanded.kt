package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile
import com.mytiki.apps_receipt_rewards.home.HomeViewModel
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.utils.components.DisplayCard
import com.mytiki.apps_receipt_rewards.utils.components.RewardsChart

@Composable
fun HomePartiallyExpanded(
    homeViewModel: HomeViewModel,
    showMoreOnClick: () -> Unit,
    navigateTo: (AccountProvider) -> Unit,
    close: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        BottomSheetHeader(
            title = "CASHBACK CONNECTIONS",
            subTitle = "Share data. Earn cash."
        ) { close() }
        Spacer(modifier = Modifier.height(48.dp))
        DisplayCard(height = 183.dp, horizontalPadding = 24.dp) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 31.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "Month", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "$${homeViewModel.earnings.value.monthCurrent} / $${homeViewModel.earnings.value.monthTotal}",
                            style = MaterialTheme.typography.displayMedium
                        )
                    }

                    Column {
                        Text(text = "Lifetime", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "$${homeViewModel.earnings.value.lifetime}",
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }


                    Text(
                        text = "Show More",
                        modifier = Modifier
                            .clickable { showMoreOnClick() },
                        style = MaterialTheme.typography.displayMedium
                    )

                }
                RewardsChart(values = listOf(homeViewModel.chartData.value))
            }
        }
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "Increase Earnings",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow {
            items(homeViewModel.alertAccountList.value) { accountCommon ->
                AccountTile(
                    accountProvider = accountCommon,
                    isConnected = true,
                    padding = PaddingValues(horizontal = 10.dp),
                    onClick = { navigateTo(accountCommon) }
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add",
                            style = MaterialTheme.typography.labelSmall,
                        )
                        Text(
                            text = accountCommon.accountName,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
            items(homeViewModel.addAccountList.value) { accountCommon ->
                AccountTile(
                    accountProvider = accountCommon,
                    isConnected = false,
                    padding = PaddingValues(horizontal = 10.dp),
                    onClick = { navigateTo(accountCommon) }
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Add",
                            style = MaterialTheme.typography.labelSmall,
                        )
                        Text(
                            text = accountCommon.accountName,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
        }
    }
}