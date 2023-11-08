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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.ui.composable.components.DisplayCard
import com.mytiki.apps_receipt_rewards.ui.composable.components.RewardsChart

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(homeViewModel: HomeViewModel, sheetState: SheetState, navigateTo: (String) -> Unit) {

    Spacer(modifier = Modifier.height(48.dp))
    DisplayCard(height = 183.dp, horizontalPadding = 24.dp) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 31.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column (
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(text = "Month", style = MaterialTheme.typography.titleSmall)
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "$4.80 / $12.00", style = MaterialTheme.typography.displayMedium)
                }

                Column {
                    Text(text = "Lifetime", style = MaterialTheme.typography.titleSmall)
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(text = "$34.30", style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.outlineVariant)
                }


                Text(
                    text = "Show More",
                    modifier = Modifier
                        .clickable {},
                    style = MaterialTheme.typography.displayMedium
                )

            }
            RewardsChart(value = homeViewModel.chartData.floatValue)
        }
    }
    Spacer(modifier = Modifier.height(48.dp))
    Text(
        modifier = Modifier.padding(horizontal = 24.dp),
        text = "Increase Earnings",
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.outline
    )
}