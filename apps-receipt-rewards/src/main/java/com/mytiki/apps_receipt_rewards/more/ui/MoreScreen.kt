package com.mytiki.apps_receipt_rewards.more.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.R
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.RewardsChart
import com.mytiki.apps_receipt_rewards.account.AccountCommon
import com.mytiki.apps_receipt_rewards.more.MoreViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MoreScreen(moreViewModel: MoreViewModel, navController: NavHostController){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(64.dp))
            Box(modifier = Modifier.padding(horizontal = 21.dp)) {
                Header(text = "BACK") {
                    navController.popBackStack()
                }
            }

            Spacer(modifier = Modifier.height(34.dp))

            Text("Monthly Estimate", modifier = Modifier.padding(horizontal = 21.dp), style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .padding(21.dp, 0.dp, 17.dp, 0.dp,)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    shape = MaterialTheme.shapes.extraSmall,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                ) {
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
                                Text(
                                    text = "Largest Contributors",
                                    style = MaterialTheme.typography.displaySmall
                                )
                                moreViewModel.chartData.keys.forEach { key ->
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "$key: ${String.format("%.0f", moreViewModel.chartData[key]?.times(100))}%",
                                        style = MaterialTheme.typography.titleSmall
                                    )
                                }
                            }
                        }
                        RewardsChart(values = moreViewModel.chartData.values.toList())
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Estimate calculated based on your spending history and available offers from eligible retailers.",
                modifier = Modifier.padding(horizontal = 21.dp),
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("Account", modifier = Modifier.padding(horizontal = 21.dp), style = MaterialTheme.typography.headlineLarge)

            Box(
                modifier = Modifier
                    .padding(21.dp, 0.dp, 17.dp, 0.dp,)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    shape = MaterialTheme.shapes.extraSmall,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                ) {
                    FlowRow(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 29.dp, vertical = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        moreViewModel.accountLists.forEach{account ->
                            AccountTile(account = account, padding = PaddingValues(horizontal = 7.dp, vertical = 12.dp), onClick = {}) {
                                Text(
                                    text = if(account.accountCommon == AccountCommon.GMAIL) account.username else account.accountCommon.accountName,
                                    style = MaterialTheme.typography.labelSmall,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text("Program Details", modifier = Modifier.padding(horizontal = 21.dp), style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .padding(21.dp, 0.dp, 17.dp, 0.dp,)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 4.dp),
                    shape = MaterialTheme.shapes.extraSmall,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    border = BorderStroke(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.outlineVariant
                    )

                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(24.dp))
                        Image(
                            painter = painterResource(id = R.drawable.ic_account),
                            contentDescription = "Account icon",
                            modifier = Modifier.size(36.dp)
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            "What data do we collect?",
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            "Learn about how your data powers your",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                        )
                        Text(
                            "cashback connections",
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                        )
                        Spacer(modifier = Modifier.height(24.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 49.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconTitle(
                                painter = painterResource(id = R.drawable.ic_purchase),
                                text = "Purchases"
                            )
                            IconTitle(
                                painter = painterResource(id = R.drawable.ic_receipt),
                                text = "Receipts"
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 49.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IconTitle(
                                painter = painterResource(id = R.drawable.ic_user_id),
                                text = "User ID"
                            )
                        }


                        Spacer(modifier = Modifier.height(48.dp))
                        Text(
                            "How is that data used?",
                            style = MaterialTheme.typography.displayMedium,
                            color = MaterialTheme.colorScheme.outlineVariant
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        IconTitle(
                            painter = painterResource(id = R.drawable.ic_cashback),
                            text = "Find cashback rewards"
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        IconTitle(
                            painter = painterResource(id = R.drawable.ic_offers),
                            text = "Relevant ads and offers"
                        )

                        Spacer(modifier = Modifier.height(12.dp))
                        IconTitle(
                            painter = painterResource(id = R.drawable.ic_chart),
                            text = "Create shopper insights"
                        )

                        Spacer(modifier = Modifier.height(48.dp))
                        Divider( modifier = Modifier.padding(bottom = 16.dp),color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .clickable {  },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Report an issue", style = MaterialTheme.typography.labelLarge)
                            Image(painter = painterResource(id = R.drawable.ic_issue), contentDescription = "", modifier = Modifier.size(18.dp))
                        }

                        Divider( modifier = Modifier.padding(vertical = 16.dp),color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .clickable {  },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Data licensing agreement", style = MaterialTheme.typography.labelLarge)
                            Image(painter = painterResource(id = R.drawable.ic_union), contentDescription = "", modifier = Modifier.size(18.dp))
                        }

                        Divider( modifier = Modifier.padding(vertical = 16.dp),color = MaterialTheme.colorScheme.outlineVariant, thickness = 1.dp)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp)
                                .clickable {  },
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Opt out of cashback connections", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.error)
                            Image(painter = painterResource(id = R.drawable.ic_block), contentDescription = "", modifier = Modifier.size(18.dp))
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }

                }
            }
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}