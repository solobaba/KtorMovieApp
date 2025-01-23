package com.xpresspayments.babamovieapp.navigation.navGraphBuilder

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.xpresspayments.babamovieapp.navigation.ScreenRoute

fun NavGraphBuilder.welcomeRoute(navController: NavController) {
    composable(route = ScreenRoute.Welcome.route) {  }
}