package com.mytiki.apps_receipt_rewards.ui.email

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
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
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.account.AccountCard
import com.mytiki.apps_receipt_rewards.ui.account.AccountDisplay
import com.mytiki.apps_receipt_rewards.ui.email.GoogleSignIn
import com.mytiki.apps_receipt_rewards.ui.utils.components.Header
import com.mytiki.apps_receipt_rewards.ui.utils.components.Input
import com.mytiki.apps_receipt_rewards.ui.utils.components.MainButton

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun EmailScreen(emailViewModel: EmailViewModel, navController: NavHostController) {
    val accountList = emailViewModel.accountLists
    val accountCommon = emailViewModel.accountCommon.value

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
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)) {
                    Spacer(modifier = Modifier.height(64.dp))
                    Header(text = accountCommon.accountName) {
                        navController.popBackStack()
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(28.dp))
                AccountDisplay(
                    accountCommon,
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
            items(accountList) {
                AccountCard(it){}
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Add Account",
                    modifier = Modifier.padding(horizontal = 21.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                    GoogleSignIn(){}
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row (modifier = Modifier
                    .padding(horizontal = 21.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                    Box(modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(MaterialTheme.colorScheme.outlineVariant)) {}
                    Text(text = "or", modifier =  Modifier.padding(horizontal = 15.dp), style = MaterialTheme.typography.displaySmall, textAlign = TextAlign.Center)
                    Box(modifier = Modifier
                        .height(1.dp)
                        .weight(1f)
                        .background(MaterialTheme.colorScheme.outlineVariant)) {}
                }
                Spacer(modifier = Modifier.height(32.dp))
                Input(tile = "Email", text = emailViewModel.username.value, isShow = true, onChange = {emailViewModel.username.value = it})
                Spacer(modifier = Modifier.height(32.dp))
                Input(tile = "Password", text = emailViewModel.password.value, isShow = false, onChange = {emailViewModel.password.value = it})
                Spacer(modifier = Modifier.height(48.dp))
                MainButton(modifier = Modifier.padding(horizontal = 21.dp), text = "Sign In", isfFilled = true) {}
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}