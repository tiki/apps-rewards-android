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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.account.AccountType
import com.mytiki.apps_receipt_rewards.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.ui.more.EstimateCard
import com.mytiki.apps_receipt_rewards.ui.more.MoreAccounts
import com.mytiki.apps_receipt_rewards.ui.more.ProgramDetails
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun MoreScreen(
    rewardsSharedViewModel: RewardsSharedViewModel,
    navController: NavHostController,
    moreViewModel: MoreViewModel = viewModel(),
) {
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

            EstimateCard(moreViewModel.monthlyEarnings.value)

            Spacer(modifier = Modifier.height(24.dp))

            MoreAccounts(
                accountsList = moreViewModel.accountLists.value,
                alertAccountsList = moreViewModel.alertAccountLists.value
            ){accountCommon ->
                rewardsSharedViewModel.selectAccount(accountCommon)
                if (accountCommon.accountType == AccountType.EMAIL) {
                    navController.navigate(RewardsRoute.EmailScreen.name)
                } else {
                    navController.navigate(RewardsRoute.RetailerScreen.name)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            ProgramDetails(rewardsSharedViewModel, navController, moreViewModel)

            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}