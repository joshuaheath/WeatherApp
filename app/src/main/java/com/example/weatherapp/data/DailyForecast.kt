package com.example.weatherapp.data

import androidx.compose.ui.graphics.vector.ImageVector
import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherType: String,
    val highCelsius: Int,
    val lowCelsius: Int,
    val chanceOfRain: Int,
    val rainAmountMM: Double,
    val humidity: Int,
    val windMaxKph: Int,
    val icon: ImageVector
)