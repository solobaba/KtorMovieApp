package com.xpresspayments.babamovieapp.navigation.navGraphBuilder

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.xpresspayments.babamovieapp.navigation.ScreenRoute
import com.xpresspayments.babamovieapp.util.Constants.MOVIE_DETAILS_ARGUMENT_KEY

fun NavGraphBuilder.movieDetailsRoute(navController: NavController) {
    composable(
        route = ScreenRoute.MovieDetails.route,
        arguments = listOf(navArgument(MOVIE_DETAILS_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { }
}