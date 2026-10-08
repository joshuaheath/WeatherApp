package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.CurrentWeather
import com.example.weatherapp.data.sampleCurrentWeather
import com.example.weatherapp.ui.theme.WeatherAppTheme

@Composable
fun CurrentWeatherScreen(model: CurrentWeather) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(model.icon),
            contentDescription = model.weatherType,
            modifier = Modifier
                .size(248.dp)
//                .offset(y = 70.dp)
//                .offset(x = 53.dp)
        )
        Text(
            model.weatherType,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            "${model.currentCelsius}°C",
            style = MaterialTheme.typography.displayLarge
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text("Feels Like ${model.feelsLikeCelsius}°C")
        Text("Wind is ${model.windDirection} at ${model.windSpeedKph}kph")
    }
}

@Preview(showBackground = true)
@Composable
fun CurrentWeatherScreenPreview() {
    WeatherAppTheme {
        CurrentWeatherScreen(sampleCurrentWeather)
    }
}