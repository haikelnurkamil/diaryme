package org.d3if0070.diaryme.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if0070.diaryme.navigation.Screen
import org.d3if0070.diaryme.ui.theme.DiaryMeTheme
import org.d3if0070.diaryme.ui.theme.TextColor

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Welcome to DiaryMe",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = TextColor
            )
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(Screen.Home.route) },
            colors = ButtonDefaults.buttonColors(TextColor)
        )
        {
            Text(
                text = "Get Start",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    DiaryMeTheme {
        WelcomeScreen(rememberNavController())
    }
}