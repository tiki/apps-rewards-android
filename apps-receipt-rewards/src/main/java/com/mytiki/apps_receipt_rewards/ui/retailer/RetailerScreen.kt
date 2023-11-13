package com.mytiki.apps_receipt_rewards.ui.retailer

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.account.AccountCard
import com.mytiki.apps_receipt_rewards.ui.account.AccountDisplay
import com.mytiki.apps_receipt_rewards.ui.utils.components.Header
import com.mytiki.apps_receipt_rewards.ui.utils.components.Input
import com.mytiki.apps_receipt_rewards.ui.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.ui.offer.OfferCard

@Composable
fun RetailerScreen(retailerViewModel: RetailerViewModel, navController: NavHostController) {
    val accountList = retailerViewModel.accountLists
    val accountCommon = retailerViewModel.accountCommon.value

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
                    239.dp,
                    "3% cashback on all purchases",
                )
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Account",
                    modifier = Modifier.padding(horizontal = 21.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            if (retailerViewModel.accountLists.isEmpty()){
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Input(tile = "Email", text = retailerViewModel.username.value, isShow = true, onChange = {retailerViewModel.username.value = it})
                    Spacer(modifier = Modifier.height(32.dp))
                    Input(tile = "Password", text = retailerViewModel.password.value, isShow = false, onChange = {retailerViewModel.password.value = it})
                    Spacer(modifier = Modifier.height(48.dp))
                    MainButton(modifier = Modifier.padding(horizontal = 21.dp), text = "Sign In", isfFilled = true) {}
                }
            } else {
                items(retailerViewModel.accountLists) {
                    AccountCard(it, false) {}
                }
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
                MainButton(modifier = Modifier.padding(horizontal = 21.dp), text = "Scan receipt", isfFilled = false) {}
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "More Offers",
                    modifier = Modifier.padding(horizontal = 21.dp),
                    style = MaterialTheme.typography.headlineLarge
                )
            }
            items(retailerViewModel.offerLists.toList()) {
                OfferCard(it){}
            }
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    }
}