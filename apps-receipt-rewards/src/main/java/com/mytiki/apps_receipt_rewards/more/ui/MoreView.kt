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
import androidx.compose.ui.window.Popup
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.Account
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.home.ui.showEmail
import com.mytiki.apps_receipt_rewards.home.ui.showRetailer
import com.mytiki.apps_receipt_rewards.ui.more.EstimateCard
import com.mytiki.apps_receipt_rewards.utils.components.Header

@Composable
fun MoreView(
    onProvider: (AccountProvider) -> Unit,
    onBackButton: () -> Unit
) {
    Popup {

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
                        onBackButton()
                    }
                }

                Spacer(modifier = Modifier.height(34.dp))

                EstimateCard(Rewards.capture.largestContributors())

                Spacer(modifier = Modifier.height(24.dp))

                MoreAccounts(
                    accountsList = Rewards.account.accounts()
                        .map { account -> account.provider },
                ) { provider ->
                    when (provider) {
                        is AccountProvider.Email -> showEmail.value = true
                        is AccountProvider.Retailer -> showRetailer.value = true
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                ProgramDetails({})

                Spacer(modifier = Modifier.height(56.dp))
            }
        }
    }
}