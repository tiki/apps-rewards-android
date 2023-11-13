package com.mytiki.apps_receipt_rewards.ui

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.*
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.mytiki.apps_receipt_rewards.databinding.RewardsActivityBinding
import com.mytiki.apps_receipt_rewards.ui.utils.navigation.RewardsNavigation
import com.mytiki.apps_receipt_rewards.ui.utils.theme.RewardsTheme

class RewardsActivity : AppCompatActivity() {

    private var _binding: RewardsActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = RewardsActivityBinding.inflate(layoutInflater)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RewardsTheme {
                    RewardsNavigation {
                        this@RewardsActivity.finish()
                        overridePendingTransition(0, R.anim.fade_out)
                    }
                }
            }
            setContentView(view)
        }
    }
}


