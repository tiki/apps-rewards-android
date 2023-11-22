package com.mytiki.apps_receipt_rewards.terms

import androidx.lifecycle.ViewModel
import com.mytiki.apps_receipt_rewards.Rewards

class TermsViewModel : ViewModel() {
    fun getTerms(): String {
        return Rewards.terms()
    }
}