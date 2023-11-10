package com.mytiki.apps_receipt_rewards.ui.composable.navigation

import com.mytiki.apps_receipt_rewards.ui.composable.screens.email.EmailScreen

enum class RewardsRoute {
    OfferScreen,
    TermsScreen,
    HomeScreen,
    EmailScreen,
    RetailerScreen;

    companion object {
        fun fromRoute(route: String?): RewardsRoute
            = when(route?.substringBefore("/")){
            OfferScreen.name -> OfferScreen
            TermsScreen.name -> TermsScreen
            HomeScreen.name -> HomeScreen
            EmailScreen.name -> EmailScreen
            RetailerScreen.name -> RetailerScreen
            null -> OfferScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
            }
    }
}