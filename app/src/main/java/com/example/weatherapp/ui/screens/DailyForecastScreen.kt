package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toLowerCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.DailyForecast
import com.example.weatherapp.data.sampleForecast
import com.example.weatherapp.ui.theme.WeatherAppTheme
import java.time.LocalDate
import java.util.Locale
import java.util.Locale.getDefault

@Composable
fun DailyForecastScreen(forecastList: List<DailyForecast>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        items(forecastList) { model ->
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    DateTimeFormatter(model.date),
                    fontWeight = FontWeight.Bold
                )
                Image(
                    painter = painterResource(model.icon),
                    contentDescription = model.weatherType,
                    modifier = Modifier.size(64.dp)
                )
                Text(
                    "${model.highCelsius}°C, low ${model.lowCelsius}°C",
                    style = MaterialTheme.typography.titleMedium
                )

                //Change description type depending on "chanceOfPrecipitation"
                if (hasPrecipitation(model.chanceOfPrecipitation)) {
                    Text(
                        "${model.weatherType}. " +
                                "Chance of precipitation: ${model.chanceOfPrecipitation}% " +
                                "Amount: ${model.precipitationMm}mm. " +
                                "Maximum winds: ${model.windMaxKph}, " +
                                "Humidity: ${model.humidity}%.",
                        textAlign = TextAlign.Center
                    )
                } else {
                    Text(
                        "${model.weatherType}." +
                                "Maximum winds: ${model.windMaxKph}kph. " +
                                "Humidity: ${model.humidity}%",
                        textAlign = TextAlign.Center
                    )
                }
                HorizontalDivider(Modifier.padding(10.dp))
            }

        }
    }
}

fun hasPrecipitation(chanceOfPrecipitation: Int): Boolean {
    return chanceOfPrecipitation >= 1
}


//@Preview(showBackground = true)
//@Composable
//fun DailyForecastScreen() {
//    WeatherAppTheme {
//        DailyForecastScreen(sampleForecast)
//    }
//}

fun DateTimeFormatter(date: LocalDate): String {
    return "${date.dayOfWeek}, ${date.month} ${date.dayOfMonth}".lowercase(getDefault())
}
