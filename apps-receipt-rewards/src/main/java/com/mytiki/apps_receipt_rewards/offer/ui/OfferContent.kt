package com.mytiki.apps_receipt_rewards.offer.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.utils.components.DisplayCard
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun OfferContent(
    navController: NavController,
) {
    val estimate = Rewards.estimate()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        DisplayCard(height = 201.dp, horizontalPadding = 15.dp, verticalPadding = 0.dp) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Earn monthly",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "\$${estimate.min} - \$${estimate.max}",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.displayLarge,
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "for your shopping habits",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            modifier = Modifier.padding(horizontal = 30.dp),
            text = "Estimate based on similar users spending habits and market price for shopping data. ",
            style = MaterialTheme.typography.labelMedium
        )
        Spacer(modifier = Modifier.height(32.dp))
        MainButton(
            modifier = Modifier.padding(horizontal = 15.dp),
            text = "Get estimate", isfFilled = true
        ) {
            navController.navigate(RewardsRoute.TermsScreen.name)
        }
        Spacer(modifier = Modifier.height(40.dp))
    }
}
