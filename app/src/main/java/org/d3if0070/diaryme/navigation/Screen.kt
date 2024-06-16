package org.d3if0070.diaryme.navigation

sealed class Screen(val route: String) {
    data object Start : Screen("welcomeScreen")
    data object Home : Screen("mainScreen")
}