package com.mobile.warehousemonitor.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.warehousemonitor.ui.components.AnalyticsChartCard
import com.mobile.warehousemonitor.ui.theme.BackgroundDark
import com.mobile.warehousemonitor.ui.theme.ChartLineHum
import com.mobile.warehousemonitor.ui.theme.ChartLineTemp

@Composable
fun AnalyticsScreen() {
    // Mock de dados temporários baseado no comportamento do seu print (X = Hora/Minutos convertidos, Y = Valor medido)
    val temperatureData = listOf(
        16.08f to 28.5f,
        17.10f to 31.2f,
        18.00f to 30.8f,
        19.13f to 31.5f,
        20.25f to 27.2f
    )

    val humidityData = listOf(
        16.14f to 58f,
        17.16f to 52f,
        18.30f to 55f,
        19.07f to 64f,
        19.20f to 90f, // Pico simulado do gráfico de umidade
        20.26f to 68f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Gráfico de Temperatura
        AnalyticsChartCard(
            title = "Variação de Temperatura",
            lineColor = ChartLineTemp,
            dataPoints = temperatureData,
        )

        // Gráfico de Umidade
        AnalyticsChartCard(
            title = "Variação de Umidade",
            lineColor = ChartLineHum,
            dataPoints = humidityData,
        )
    }
}