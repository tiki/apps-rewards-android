package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.utils.components.BottomSheetHeader
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun HomeView(
    navController: NavController,
    close: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        BottomSheetHeader(
            title = "CASHBACK CONNECTIONS",
            subTitle = "Share data. Earn cash."
        ) { close() }
        Spacer(modifier = Modifier.height(48.dp))
        HomeCard(navController)
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            modifier = Modifier.padding(horizontal = 24.dp),
            text = "Increase Earnings",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.outline
        )
        Spacer(modifier = Modifier.height(24.dp))
        HomeCarousel { accountProvider ->
//            if (accountProvider == AccountType.EMAIL) {
//                navController.navigate(RewardsRoute.EmailScreen.name)
//            } else {
//                navController.navigate(RewardsRoute.RetailerScreen.name)
//            }
        }
    }
}
