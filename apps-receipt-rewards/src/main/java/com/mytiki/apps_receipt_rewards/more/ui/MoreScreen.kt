package com.mytiki.apps_receipt_rewards.more.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.ui.more.EstimateCard
import com.mytiki.apps_receipt_rewards.ui.more.MoreAccounts
import com.mytiki.apps_receipt_rewards.ui.more.ProgramDetails
import com.mytiki.apps_receipt_rewards.utils.components.Header

@Composable
fun MoreScreen(moreViewModel: MoreViewModel, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Box(modifier = Modifier.padding(horizontal = 21.dp)) {
                Header(text = "BACK") {
                    navController.popBackStack()
                }
            }

            Spacer(modifier = Modifier.height(34.dp))

            EstimateCard(moreViewModel.chartData)

            Spacer(modifier = Modifier.height(24.dp))

            MoreAccounts(accountsList = moreViewModel.accountLists)

            Spacer(modifier = Modifier.height(30.dp))

            ProgramDetails()

            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}