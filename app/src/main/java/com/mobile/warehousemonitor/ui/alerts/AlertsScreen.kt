package com.mobile.warehousemonitor.ui.alerts

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.theme.BackgroundDark
import com.mobile.warehousemonitor.ui.theme.CardBackground
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

@Composable
fun AlertsScreen() {
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
            text = "Configuração de Alertas",
            color = TextPrimary,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Defina os limites de temperatura e recebimento de notificações.",
            color = TextSecondary,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Environment Alert Configuration List
        AlertConfigCard(
            name = "Armazem Nº1",
            description = "Armazem azul",
            tag = "arejado",
            tempMin = "15",
            tempMax = "30",
            humMin = "0",
            humMax = "70"
        )

        Spacer(modifier = Modifier.height(24.dp))

        AlertConfigCard(
            name = "Geladeira Nº1",
            description = "Sem descrição",
            tag = "frio",
            tempMin = "2",
            tempMax = "8",
            humMin = "40",
            humMax = "60"
        )
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun AlertConfigCard(
    name: String,
    description: String,
    tag: String,
    tempMin: String,
    tempMax: String,
    humMin: String,
    humMax: String
) {
    var checked by remember { mutableStateOf(true) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = TextSecondary,
                        checkmarkColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(text = name, color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = description, color = TextSecondary, fontSize = 14.sp)
                }
            }

            Surface(
                color = Color(0xFF2D3848),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(start = 48.dp, top = 8.dp)
            ) {
                Text(
                    text = tag,
                    color = TextSecondary,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Temperature Config
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF251C1C)) // Dark red tint
                    .border(1.dp, Color(0xFF422525), RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = Color(0xFFE57373))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Temperatura", color = TextPrimary, fontWeight = FontWeight.Bold)
                        }
                        Text(text = "°C", color = Color(0xFFE57373), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Mínima", color = TextSecondary, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            AlertInputField(value = tempMin, borderColor = Color(0xFFE57373))
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Máxima", color = TextSecondary, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            AlertInputField(value = tempMax, borderColor = Color(0xFFE57373))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Humidity Config
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1C2125)) // Dark blue tint
                    .border(1.dp, Color(0xFF252D42), RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = null, tint = Color(0xFF42A5F5))
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Umidade", color = TextPrimary, fontWeight = FontWeight.Bold)
                        }
                        Text(text = "%", color = Color(0xFF42A5F5), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Mínima", color = TextSecondary, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            AlertInputField(value = humMin, borderColor = Color(0xFF42A5F5))
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = "Máxima", color = TextSecondary, fontSize = 12.sp)
                            Spacer(modifier = Modifier.height(4.dp))
                            AlertInputField(value = humMax, borderColor = Color(0xFF42A5F5))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AlertInputField(value: String, borderColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF16202C))
            .border(1.dp, borderColor.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ) {
        Text(text = value, color = TextPrimary, fontWeight = FontWeight.Bold)
    }
}
