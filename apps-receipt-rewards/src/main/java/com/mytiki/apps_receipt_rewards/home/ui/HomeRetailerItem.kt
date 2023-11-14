package com.mytiki.apps_receipt_rewards.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.account.ui.AccountTile
import com.mytiki.apps_receipt_rewards.account.Account

@Composable
fun HomeRetailerItem(account: Account, paddingValues: PaddingValues = PaddingValues(0.dp), onClick: (Account) -> Unit) {
    AccountTile(
        account = account,
        padding = paddingValues,
        onClick = { onClick(account) }
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
                text = account.accountCommon.accountName,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}