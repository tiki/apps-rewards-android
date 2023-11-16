package com.mytiki.apps_receipt_rewards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.*
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.lifecycle.ViewModelProvider
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.email.EmailViewModel
import com.mytiki.apps_receipt_rewards.home.HomeViewModel
import com.mytiki.apps_receipt_rewards.more.MoreViewModel
import com.mytiki.apps_receipt_rewards.offer.OfferViewModel
import com.mytiki.apps_receipt_rewards.retailer.RetailerViewModel
import com.mytiki.apps_receipt_rewards.terms.TermsViewModel
import com.mytiki.apps_receipt_rewards.ui.RewardsViewModel
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsNavigation
import com.mytiki.apps_receipt_rewards.utils.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rewardsViewModel = ViewModelProvider(this)[RewardsViewModel::class.java]
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RewardsTheme {
                    RewardsNavigation(rewardsViewModel) {
                        this@RewardsActivity.finish()
                        overridePendingTransition(0, R.anim.fade_out)
                    }
                }
            }
            setContentView(view)
        }
    }
}



