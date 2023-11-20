package com.mytiki.apps_receipt_rewards

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsNavigation
import com.mytiki.apps_receipt_rewards.utils.navigation.RewardsRoute
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RewardsNavigationTest {
    @get: Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun startScreenLicenseDeclinedTest() {
        composeTestRule.setContent {
            val navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            Rewards.decline()
            RewardsNavigation(navController = navController) {}
            navController.assertCurrentRouteName(RewardsRoute.OfferScreen.name)
        }
    }

    @Test
    fun startScreenLicenseAcceptedTest() {
        composeTestRule.setContent {
            val navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            Rewards.license()
            RewardsNavigation(navController = navController) {}
            navController.assertCurrentRouteName(RewardsRoute.HomeScreen.name)
        }
    }

}
