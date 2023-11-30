package com.mytiki.apps_receipt_rewards.email.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mytiki.apps_receipt_rewards.Rewards
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.account.ui.AccountCard
import com.mytiki.apps_receipt_rewards.account.ui.AccountDisplay
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.LoginForm

@Composable
fun EmailView(
    provider: AccountProvider,
    onBack: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()

        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp)
                ) {
                    Spacer(modifier = Modifier.height(64.dp))
                    Header(text = "") {
                        onBack()
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(28.dp))
                        AccountDisplay(
                            provider,
                            275.dp,
                            "When you connect your Gmail account, we auto-identify receipts and process available cashback rewards",
                        )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Accounts",
                    modifier = Modifier.padding(horizontal = 21.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            val accounts = Rewards.account.accounts()
            if (accounts.isEmpty()) {
                item {
                    LoginForm()
                }
            } else {
                items(accounts) {
                    Spacer(modifier = Modifier.height(32.dp))
                    AccountCard(it, false) { Rewards.account.logout(it.username, it.provider) }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            item {
                Spacer(modifier = Modifier.height(38.dp))
                Text(
                    text = "Add Account",
                    modifier = Modifier.padding(horizontal = 21.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(46.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    GoogleSignIn { }
                }
                Spacer(modifier = Modifier.height(38.dp))
                Row(
                    modifier = Modifier
                        .padding(horizontal = 21.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.outlineVariant)
                    ) {}
                    Text(
                        text = "or",
                        modifier = Modifier.padding(horizontal = 15.dp),
                        style = MaterialTheme.typography.displaySmall,
                        textAlign = TextAlign.Center
                    )
                    Box(
                        modifier = Modifier
                            .height(1.dp)
                            .weight(1f)
                            .background(MaterialTheme.colorScheme.outlineVariant)
                    ) {}
                }
                Spacer(modifier = Modifier.height(32.dp))

                LoginForm()

            }
        }
    }
}