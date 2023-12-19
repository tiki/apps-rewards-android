package com.mytiki.apps_receipt_rewards

import org.junit.Test

class RewardsTest {

    @Test
    fun licenseTest(){
        Rewards.licenses("Test", "Test", "Test")
        assert(Rewards.licenseConfig.tikiPublishingID == "Test")
        assert(Rewards.licenseConfig.microblinkLicenseKey == "Test")
        assert(Rewards.licenseConfig.productIntelligenceKey == "Test")
    }

    @Test
    fun oauthTest(){
        Rewards.oauth(
            "test",
           "test",
        )
        assert(Rewards.oauth.gmailAPIKey == "test")
        assert(Rewards.oauth.outlookAPIKey == "test")
    }

}