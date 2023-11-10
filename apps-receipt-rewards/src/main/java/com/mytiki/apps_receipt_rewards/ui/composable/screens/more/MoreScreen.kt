package com.mytiki.apps_receipt_rewards.ui.composable.screens.more

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.DisplayCard
import com.mytiki.apps_receipt_rewards.ui.composable.components.Header
import com.mytiki.apps_receipt_rewards.ui.composable.components.RewardsChart
import com.mytiki.apps_receipt_rewards.ui.composable.screens.retailer.RetailerViewModel

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
                    RewardsChart(values = moreViewModel.chartData)
                }
            }
        }
    }
}