package com.mobile.warehousemonitor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.theme.AccentBlue
import com.mobile.warehousemonitor.ui.theme.CardBackground
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

@Composable
fun EnvironmentCard(
    name: String,
    description: String,
    tag: String,
    totalDevices: Int,
    modifier: Modifier = Modifier,
    onDetailsClick: () -> Unit = {},
    onViewDevicesClick: () -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = name,
                        color = TextPrimary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = description,
                        color = TextSecondary,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                    
                    Surface(
                        color = Color(0xFF2D3848), // Um tom um pouco mais claro que o card
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(
                            text = tag,
                            color = TextSecondary,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF2D3848)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null,
                        tint = AccentBlue,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Total de Dispositivos",
                    color = TextSecondary,
                    fontSize = 14.sp
                )
                Text(
                    text = totalDevices.toString(),
                    color = TextPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = onDetailsClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2D3848),
                        contentColor = TextPrimary
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(text = "Detalhes", fontSize = 14.sp)
                }

                TextButton(onClick = onViewDevicesClick) {
                    Text(
                        text = "Ver dispositivos →",
                        color = AccentBlue,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}
