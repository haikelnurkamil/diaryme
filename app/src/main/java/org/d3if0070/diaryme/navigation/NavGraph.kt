package org.d3if0070.diaryme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.d3if0070.diaryme.ui.screen.MainScreen
import org.d3if0070.diaryme.ui.screen.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start.route,
    ) {
        composable(route = Screen.Start.route) {
            WelcomeScreen(navController)
        }
        composable(route = Screen.Home.route) {
            MainScreen()
        }
    }
}