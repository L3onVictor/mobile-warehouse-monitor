package com.mobile.warehousemonitor.ui.devices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.theme.*

@Composable
fun DeviceMonitoringScreen(
    deviceName: String = "ESP Nº1",
    onBack: () -> Unit
) {
    var selectedFilter by remember { mutableStateOf("Últimas 24h") }
    val filters = listOf("Últimas 24h", "7 Dias", "30 Dias")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "IoT Dashboard",
                color = TextPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = TextPrimary
                )
            }
        }

        // Breadcrumb
        Text(
            text = "Dispositivos  /  $deviceName  /  Monitoramento",
            color = TextSecondary,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Monitoramento: $deviceName",
            color = TextPrimary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 34.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Filter Row
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(CardBackground)
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            filters.forEach { filter ->
                val isSelected = filter == selectedFilter
                Button(
                    onClick = { selectedFilter = filter },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) Color(0xFF2D3848) else Color.Transparent,
                        contentColor = if (isSelected) TextPrimary else TextSecondary
                    ),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    elevation = null
                ) {
                    Text(text = filter, fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Temperature Card
        MonitoringGradientCard(
            label = "Temperatura Atual",
            value = "27.8°C",
            timestamp = "06/02/2026, 20:25:35",
            icon = Icons.Default.KeyboardArrowUp,
            gradient = Brush.verticalGradient(listOf(Color(0xFFF06522), Color(0xFFF39422)))
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Humidity Card
        MonitoringGradientCard(
            label = "Umidade Atual",
            value = "68.9%",
            timestamp = "06/02/2026, 20:26:06",
            icon = Icons.Default.KeyboardArrowDown,
            gradient = Brush.verticalGradient(listOf(Color(0xFF0083B0), Color(0xFF00B4DB)))
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Secondary Cards
        SecondaryMonitoringCard(label = "Temperatura Mínima", value = "27.7 °C", color = Color(0xFFE53935))
        Spacer(modifier = Modifier.height(12.dp))
        SecondaryMonitoringCard(label = "Temperatura Média", value = "30.7 °C", color = Color(0xFFE53935))
        Spacer(modifier = Modifier.height(12.dp))
        SecondaryMonitoringCard(label = "Temperatura Máxima", value = "32.4 °C", color = Color(0xFFE53935))

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun MonitoringGradientCard(
    label: String,
    value: String,
    timestamp: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    gradient: Brush
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(gradient)
            .padding(24.dp)
    ) {
        Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = label, color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                Text(text = value, color = Color.White, fontSize = 42.sp, fontWeight = FontWeight.Bold)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.size(14.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = timestamp, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
            }
        }
        
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(56.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(32.dp))
        }
    }
}

@Composable
fun SecondaryMonitoringCard(label: String, value: String, color: Color) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.height(IntrinsicSize.Min)) {
            // Left Indicator Line
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .background(color)
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = label, color = TextSecondary, fontSize = 12.sp)
                Text(text = value, color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
