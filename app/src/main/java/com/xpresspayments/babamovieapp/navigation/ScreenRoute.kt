package com.xpresspayments.babamovieapp.navigation

sealed class ScreenRoute(val route: String) {
    object Splash: ScreenRoute(route = "splashScreen")
    object Welcome: ScreenRoute(route = "welcomeScreen")
    object Home: ScreenRoute(route = "homeScreen")
    object MovieDetails: ScreenRoute(route = "movieDetailsScreen/{heroId}") {
        fun passHeroID(heroId: Int): String {
            return "detailsScreen/$heroId"
        }
    }
    object Search: ScreenRoute(route = "searchScreen")
}