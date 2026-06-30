package com.mobile.warehousemonitor.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.components.AnalyticsChartCard
import com.mobile.warehousemonitor.ui.components.SensorCard
import com.mobile.warehousemonitor.ui.theme.*

@Composable
fun MainDashboardScreen() {
    var selectedPeriod by remember { mutableStateOf("Mês") }
    val periods = listOf("Ano", "Mês", "Dia")

    // Mock de dados para os gráficos (usando índices simples para o eixo X para evitar erros de precisão)
    val temperatureData = listOf(
        0f to 28.5f,
        1f to 31.2f,
        2f to 30.8f,
        3f to 31.5f,
        4f to 27.2f
    )

    val humidityData = listOf(
        0f to 58f,
        1f to 52f,
        2f to 55f,
        3f to 64f,
        4f to 90f,
        5f to 68f
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Permite rolar a tela toda para baixo
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- SEÇÃO 1: TOPO E FILTROS ---
        Text(
            text = "Dashboard de Sensores",
            color = TextPrimary,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            periods.forEach { period ->
                val isSelected = period == selectedPeriod
                Button(
                    onClick = { selectedPeriod = period },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) AccentBlue else CardBackground
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp)
                ) {
                    Text(text = period, color = TextPrimary)
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(CardBackground)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Todos os Ambientes", color = TextPrimary)
                Icon(Icons.Default.ArrowDropDown, contentDescription = null, tint = TextSecondary)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(CardBackground)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.DateRange, contentDescription = null, tint = TextSecondary, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "janeiro de 2025", color = TextPrimary, fontSize = 14.sp)
            }

            Text(text = "—", color = TextSecondary)

            Row(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(8.dp))
                    .background(CardBackground)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.DateRange, contentDescription = null, tint = TextSecondary, modifier = Modifier.size(18.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "junho de 2025", color = TextPrimary, fontSize = 14.sp)
            }
        }

        // --- SEÇÃO 2: CARTÕES DE SENSORES ---
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SensorCard(label = "Temperatura Mínima", value = "27.7 °C", indicatorColor = TempIndicator)
            SensorCard(label = "Temperatura Média", value = "30.7 °C", indicatorColor = TempIndicator)
            SensorCard(label = "Temperatura Máxima", value = "32.4 °C", indicatorColor = TempIndicator)

            SensorCard(label = "Umidade Mínima", value = "51.9 %", indicatorColor = HumidityIndicator)
            SensorCard(label = "Umidade Média", value = "59.9 %", indicatorColor = HumidityIndicator)
            SensorCard(label = "Umidade Máxima", value = "65.2 %", indicatorColor = HumidityIndicator)
        }

        // Divisor estético opcional para separar os blocos de dados
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            color = CardBackground,
            thickness = 1.dp
        )

        // --- SEÇÃO 3: GRÁFICOS (ABAIXO DOS CARTÕES) ---
        AnalyticsChartCard(
            title = "Variação de Temperatura",
            lineColor = ChartLineTemp,
            dataPoints = temperatureData,
        )

        AnalyticsChartCard(
            title = "Variação de Umidade",
            lineColor = ChartLineHum,
            dataPoints = humidityData,
        )

        Spacer(modifier = Modifier.height(16.dp)) // Espaço extra no fim da rolagem
    }
}