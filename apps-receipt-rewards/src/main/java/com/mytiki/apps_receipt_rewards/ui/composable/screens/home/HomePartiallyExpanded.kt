package com.mytiki.apps_receipt_rewards.ui.composable.screens.home

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
import com.mytiki.apps_receipt_rewards.ui.composable.components.AccountTile
import com.mytiki.apps_receipt_rewards.ui.composable.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.ui.composable.components.DisplayCard
import com.mytiki.apps_receipt_rewards.ui.composable.components.RewardsChart
import com.mytiki.apps_receipt_rewards.ui.model.account.Account

@Composable
fun HomePartiallyExpanded(homeViewModel: HomeViewModel, navigateTo: (Account) -> Unit, close: () -> Unit) {
    Column {
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
                            text = "$4.80 / $12.00",
                            style = MaterialTheme.typography.displayMedium
                        )
                    }

                    Column {
                        Text(text = "Lifetime", style = MaterialTheme.typography.titleSmall)
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "$34.30",
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                    }


                    Text(
                        text = "Show More",
                        modifier = Modifier
                            .clickable {},
                        style = MaterialTheme.typography.displayMedium
                    )

                }
                RewardsChart(values = homeViewModel.chartData)
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
            items(homeViewModel.accountLists.toList()) { account ->
                AccountTile(
                    account = account,
                    padding = PaddingValues(horizontal = 10.dp),
                    onClick = { navigateTo(account) }
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
                            text = account.accountCommon.accountName,
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }
        }
    }
}