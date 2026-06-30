package com.mobile.warehousemonitor.ui.devices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.theme.*

@Composable
fun DeviceDetailScreen(
    deviceName: String = "ESP Nº1",
    macAddress: String = "80:F3:DA:63:4B:B8",
    environment: String = "teste",
    onBack: () -> Unit
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = onBack,
                colors = ButtonDefaults.buttonColors(containerColor = CardBackground),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Voltar para lista", fontSize = 14.sp)
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                TextButton(onClick = { /* Editar */ }) {
                    Text(text = "Editar", color = Color(0xFF1E88E5))
                }
                TextButton(onClick = { /* Excluir */ }) {
                    Text(text = "Excluir", color = Color(0xFFE53935))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Device Detail Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = CardBackground),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF2D2548)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add, // Bolt/Flash icon placeholder
                            contentDescription = null,
                            tint = Color(0xFFA182FF),
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(
                            text = deviceName,
                            color = TextPrimary,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = macAddress,
                            color = TextSecondary,
                            fontSize = 14.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "ID do Sistema", color = TextSecondary, fontSize = 14.sp)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF16202C))
                        .padding(16.dp)
                ) {
                    Text(text = macAddress, color = TextPrimary, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(text = "Ambiente Vinculado", color = TextSecondary, fontSize = 14.sp)
                Text(
                    text = environment,
                    color = TextPrimary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))

        // Footer
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "© 2026 IoT Dashboard. Todos os direitos reservados.",
                color = TextSecondary,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Desenvolvido por", color = TextSecondary, fontSize = 12.sp)
            Text(text = "Leonardo Victor", color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Rafael Felix", color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            Text(text = "Victor Machado", color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}
