package com.example.weatherapp.data

import androidx.compose.ui.graphics.vector.ImageVector

data class CurrentWeather(
    val weatherType: String,
    val currentCelsius: Int,
    val feelsLikeCelsius: Int,
    val windDirection: String,
    val windSpeedKph: Int,
    val icon: ImageVector
)
