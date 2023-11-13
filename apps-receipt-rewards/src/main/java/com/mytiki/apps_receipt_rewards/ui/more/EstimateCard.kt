package com.mytiki.apps_receipt_rewards.ui.more

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.ui.utils.components.RewardsChart

@Composable
fun EstimateCard(data: Map<String, Float>) {
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
                        data.keys.forEach { key ->
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = "$key: ${String.format("%.0f", data[key]?.times(100))}%",
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
                RewardsChart(values = data.values.toList())
            }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Text(
        text = "Estimate calculated based on your spending history and available offers from eligible retailers.",
        modifier = Modifier.padding(horizontal = 21.dp),
        style = MaterialTheme.typography.titleSmall
    )
}