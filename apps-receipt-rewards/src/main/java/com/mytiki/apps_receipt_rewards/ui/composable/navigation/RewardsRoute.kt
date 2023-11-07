package com.mytiki.apps_receipt_rewards.ui.composable.navigation

enum class RewardsRoute {
    OfferScreen,
    TermsScreen,
    HomeScreen;

    companion object {
        fun fromRoute(route: String?): RewardsRoute
            = when(route?.substringBefore("/")){
            OfferScreen.name -> OfferScreen
            TermsScreen.name -> TermsScreen
            HomeScreen.name -> HomeScreen
            null -> OfferScreen
            else -> throw IllegalArgumentException("Route $route is not recognize")
            }
    }
}