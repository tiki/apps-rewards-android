package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile
import com.mytiki.apps_receipt_rewards.home.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeExpanded(homeViewModel: HomeViewModel, navigateTo: (AccountCommon) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Spacer(modifier = Modifier.height(49.dp))
            Text(
                modifier = Modifier.padding(horizontal = 24.dp),
                text = "Increase Earnings",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.outline
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        item {
            FlowRow(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                maxItemsInEachRow = 3
            ) {
                homeViewModel.alertAccountList.value.forEach { accountCommon ->
                    AccountTile(
                        accountCommon = accountCommon,
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
                homeViewModel.addAccountList.value.forEach { accountCommon ->
                    AccountTile(
                        accountCommon = accountCommon,
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
}