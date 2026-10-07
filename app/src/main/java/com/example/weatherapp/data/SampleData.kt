package com.example.weatherapp.data

import com.example.weatherapp.R
import java.time.LocalDate

val sampleCurrentWeather = CurrentWeather(
    weatherType = "Sunny",
    currentCelsius = 20,
    feelsLikeCelsius = 19,
    windDirection = "SW",
    windSpeedKph = 12,
    icon = R.drawable.ic_clear_day
)

val sampleForecast = listOf(
    DailyForecast(
        date = LocalDate.of(2026, 4, 25),
        weatherType = "Sunny",
        highCelsius = 21,
        lowCelsius = 15,
        chanceOfPrecipitation = 0,
        precipitationMm = 0.00,
        humidity = 45,
        windMaxKph = 16,
        icon = R.drawable.ic_clear_day
    ),
    DailyForecast(
        date = LocalDate.of(2026, 4, 26),
        weatherType = "Cloudy",
        highCelsius = 14,
        lowCelsius = 9,
        chanceOfPrecipitation = 30,
        precipitationMm = 2.35,
        humidity = 50,
        windMaxKph = 20,
        icon = R.drawable.ic_cloudy_day
    ),
    DailyForecast(
        date = LocalDate.of(2026, 4, 27),
        weatherType = "Rainy",
        highCelsius = 17,
        lowCelsius = 14,
        chanceOfPrecipitation = 100,
        precipitationMm = 30.67,
        humidity = 85,
        windMaxKph = 13,
        icon = R.drawable.ic_rainy_day
    ),
    DailyForecast(
        date = LocalDate.of(2026, 4, 28),
        weatherType = "Thunderstorm",
        highCelsius = 17,
        lowCelsius = 14,
        chanceOfPrecipitation = 100,
        precipitationMm = 43.56,
        humidity = 70,
        windMaxKph = 28,
        icon = R.drawable.ic_thunderstorms
    ),
    DailyForecast(
        date = LocalDate.of(2026, 4, 29),
        weatherType = "Snowy",
        highCelsius = 1,
        lowCelsius = -10,
        chanceOfPrecipitation = 35,
        precipitationMm = 12.00,
        humidity = 40,
        windMaxKph = 6,
        icon = R.drawable.ic_snowy_day
    ),
    DailyForecast(
        date = LocalDate.of(2026, 4, 30),
        weatherType = "Frost",
        highCelsius = 2,
        lowCelsius = -5,
        chanceOfPrecipitation = 20,
        precipitationMm = 9.00,
        humidity = 50,
        windMaxKph = 8,
        icon = R.drawable.ic_snowy_day
    ),
)