package com.example.weatherapp.data

import androidx.annotation.DrawableRes
import java.time.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val weatherType: String,
    val highCelsius: Int,
    val lowCelsius: Int,
    val chanceOfPrecipitation: Int,
    val precipitationMm: Double,
    val humidity: Int,
    val windMaxKph: Int,
    @DrawableRes val icon: Int
)