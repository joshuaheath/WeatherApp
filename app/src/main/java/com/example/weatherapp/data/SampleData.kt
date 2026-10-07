package com.example.weatherapp.data

import com.example.weatherapp.R
import java.time.LocalDate

val sampleCurrentWeather = CurrentWeather(
    "Sunny",20,
    19,"SW",
    12, icon = R.drawable.ic_clear_day
)

val sampleForecast = listOf(
    DailyForecast(
        date = LocalDate.of(2026, 4, 27),
        weatherType = "Sunny",
        highCelsius = 21,
        lowCelsius = 15,
        chanceOfRain = 0,
        rainAmountMM = 0.00,
        humidity = 10,
        windMaxKph = 16,
        icon = R.drawable.ic_clear_day
    ),
    //Create Other days
)