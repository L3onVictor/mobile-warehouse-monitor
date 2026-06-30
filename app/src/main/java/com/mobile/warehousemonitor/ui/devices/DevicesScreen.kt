package com.mobile.warehousemonitor.ui.devices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.components.DeviceItemCard
import com.mobile.warehousemonitor.ui.theme.AccentBlue
import com.mobile.warehousemonitor.ui.theme.BackgroundDark
import com.mobile.warehousemonitor.ui.theme.CardBackground
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

@Composable
fun DevicesScreen(
    onMonitorClick: (String) -> Unit = {},
    onDetailsClick: (String) -> Unit = {}
) {
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
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = TextPrimary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Dispositivos",
            color = TextPrimary,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Gerencie seus sensores e controladores IoT por ambiente.",
            color = TextSecondary,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Novo Dispositivo */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = AccentBlue),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Novo Dispositivo", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Summary Cards
        DeviceSummaryCard(label = "Total de Dispositivos", value = "2")
        Spacer(modifier = Modifier.height(16.dp))
        DeviceSummaryCard(label = "Ambientes Monitorados", value = "1")
        Spacer(modifier = Modifier.height(16.dp))
        DeviceSummaryCard(label = "Dispositivos Sem Ambiente", value = "1")

        Spacer(modifier = Modifier.height(32.dp))

        // Environment Device List
        EnvironmentDeviceHeader(name = "Armazem Nº1", count = 0)
        Text(
            text = "Nenhum dispositivo neste ambiente.",
            color = TextSecondary,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        )

        EnvironmentDeviceHeader(name = "Geladeira Nº1", count = 0)
        Text(
            text = "Nenhum dispositivo neste ambiente.",
            color = TextSecondary,
            fontSize = 14.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 16.dp, bottom = 32.dp)
        )

        EnvironmentDeviceHeader(name = "teste", count = 1)
        Spacer(modifier = Modifier.height(16.dp))
        DeviceItemCard(
            name = "ESP Nº1",
            macAddress = "80:F3:DA:63:4B:B8",
            temperature = "27.8°C",
            humidity = "68.9%",
            onMonitorClick = { onMonitorClick("ESP Nº1") },
            onDetailsClick = { onDetailsClick("ESP Nº1") }
        )
        Spacer(modifier = Modifier.height(32.dp))

        EnvironmentDeviceHeader(name = "Sem Ambiente", count = 1)
        Spacer(modifier = Modifier.height(16.dp))
        DeviceItemCard(
            name = "ESP Nº2",
            macAddress = "00:00:00:00:00:00",
            temperature = null,
            humidity = null,
            onMonitorClick = { onMonitorClick("ESP Nº2") },
            onDetailsClick = { onDetailsClick("ESP Nº2") }
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun DeviceSummaryCard(label: String, value: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text(text = label, color = TextSecondary, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = value, color = TextPrimary, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun EnvironmentDeviceHeader(name: String, count: Int) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = name,
                color = TextPrimary,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(12.dp))
            Surface(
                color = Color(0xFF2D3848),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = count.toString(),
                    color = TextSecondary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(color = Color(0xFF2D3848), thickness = 1.dp)
    }
}
