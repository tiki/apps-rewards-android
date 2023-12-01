package com.mytiki.apps_receipt_rewards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.mytiki.apps_receipt_rewards.account.AccountProvider
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.email.ui.EmailView
import com.mytiki.apps_receipt_rewards.home.ui.HomeView
import com.mytiki.apps_receipt_rewards.license.ui.LicenseTerms
import com.mytiki.apps_receipt_rewards.license.ui.LicenseView
import com.mytiki.apps_receipt_rewards.more.ui.MoreView
import com.mytiki.apps_receipt_rewards.retailer.RetailerView
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!
    private val licensed = mutableStateOf( Rewards.license.isLicensed() )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                val startDestination = if(Rewards.license.isLicensed()) {
                    "home"
                }else {
                    "license"
                }
                val provider = mutableStateOf<AccountProvider?>(null)
                RewardsTheme(Rewards.colorScheme) {
                    NavHost(navController, startDestination) {
                            composable("license") { LicenseView(
                                onAccept = {

                                },
                                onDismiss = {

                                }
                            ) }
                            composable("terms") {
                                LicenseTerms(
                                    onBackButton = {
                                        navController.popBackStack()
                                })
                            }
                            composable("home") {
                                HomeView( { prov: AccountProvider ->
                                    provider.value = prov
                                }){
                                    finish()
                                }
                            }
                            composable("more") {
                                MoreView( { prov: AccountProvider ->
                                    provider.value = prov
                                }){
                                    navController.popBackStack()
                            }
                            composable("retailer") {
                                RetailerView {
                                    navController.popBackStack()
                                }
                            }
                            composable("email") {
                                EmailView(provider.value!!){
                                    navController.popBackStack()
                                }
                            }
                        }
                    }
                }
            }
        }
        setContentView(view)
    }
}



