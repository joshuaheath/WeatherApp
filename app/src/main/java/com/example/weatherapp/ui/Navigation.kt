package com.example.weatherapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weatherapp.data.sampleCurrentWeather
import com.example.weatherapp.data.sampleForecast
import com.example.weatherapp.ui.screens.CurrentWeatherScreen
import com.example.weatherapp.ui.screens.DailyForecastScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
//                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    containerColor = Color.hsv(120F, 0.75F, 0.6F),
                    titleContentColor = Color.Black,
                ),
                title = { Text("Halifax, Nova Scotia") }
            )
        },
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets,
                containerColor = Color.hsv(120F, 0.6F, 0.8F),)
            {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Schedule,
                            contentDescription = "TEST"
                        )
                    },
                    label = { Text("Now")},
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(route = "currentWeather") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.hsv(120F, 0.3F, 0.95F),   // the pill behind the selected icon
                        selectedIconColor = Color.Black,
                        selectedTextColor = Color.Black,
                        unselectedIconColor = Color.hsv(120F, 0.75F, 0.3F),
                        unselectedTextColor = Color.hsv(120F, 0.75F, 0.3F)
                    )
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = "TEST"
                        )
                    },
                    label = { Text("Daily")},
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(route = "dailyForecast") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.hsv(120F, 0.3F, 0.95F),   // the pill behind the selected icon
                        selectedIconColor = Color.Black,
                        selectedTextColor = Color.Black,
                        unselectedIconColor = Color.hsv(120F, 0.75F, 0.3F),
                        unselectedTextColor = Color.hsv(120F, 0.75F, 0.3F)
                    )
                )

            }
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "currentWeather",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "currentWeather") {
                CurrentWeatherScreen(sampleCurrentWeather)
            }
            composable(route = "dailyForecast") {
                DailyForecastScreen(sampleForecast)
            }
        }
    }
}
