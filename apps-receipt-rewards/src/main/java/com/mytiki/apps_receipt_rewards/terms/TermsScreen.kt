package com.mytiki.apps_receipt_rewards.terms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.mytiki.apps_receipt_rewards.ui.RewardsSharedViewModel
import com.mytiki.apps_receipt_rewards.utils.components.Header
import com.mytiki.apps_receipt_rewards.utils.components.MainButton
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute

@Composable
fun TermsScreen(
    rewardsSharedViewModel: RewardsSharedViewModel,
    navController: NavHostController,
    termsViewModel: TermsViewModel = viewModel(),
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .fillMaxSize(),

            topBar = {
                Column {
                    Spacer(modifier = Modifier.height(60.dp))
                    Header(text = "PROGRAM TERMS") {
                        rewardsSharedViewModel.declineLicense()
                        navController.popBackStack()
                    }
                }
            },
            bottomBar = {
                Column {
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
                    Spacer(modifier = Modifier.height(42.dp))
                    if (!rewardsSharedViewModel.isLicensed.collectAsState().value) {
                        MainButton(
                            text = "I agree", isfFilled = true
                        ) {

                            rewardsSharedViewModel.createLicense()
                            navController.navigate(RewardsRoute.HomeScreen.name)
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }
            },
            containerColor = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(it),
            ) {
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = termsViewModel.getTerms(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

            }

        }
    }
}