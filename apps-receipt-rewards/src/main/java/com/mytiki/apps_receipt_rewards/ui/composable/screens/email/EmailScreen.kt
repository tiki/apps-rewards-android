package com.mytiki.apps_receipt_rewards.ui.composable.screens.email

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.composable.components.AccountDisplay
import com.mytiki.apps_receipt_rewards.ui.composable.components.Header
import com.mytiki.apps_receipt_rewards.ui.model.Account

@Composable
fun EmailScreen(emailViewModel: EmailViewModel, navController: NavHostController, account: Account) {

    LazyColumn{
        item {
            Header(text = account.accountCommon.accountName) {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(28.dp))
            AccountDisplay(account, 275.dp, "When you connect your Gmail account, we auto-identify receipts and process available cashback rewards")
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Accounts", style = MaterialTheme.typography.headlineLarge)

        }

    }
}