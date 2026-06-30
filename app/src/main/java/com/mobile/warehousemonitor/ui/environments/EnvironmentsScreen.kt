package com.mobile.warehousemonitor.ui.environments

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.components.EnvironmentCard
import com.mobile.warehousemonitor.ui.theme.AccentBlue
import com.mobile.warehousemonitor.ui.theme.BackgroundDark
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

@Composable
fun EnvironmentsScreen(
    onEnvironmentClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // ... (resto do cabeçalho e botão Novo Ambiente permanece igual)
        // Top Bar Mock
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
            text = "Ambientes",
            color = TextPrimary,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Gerencie as áreas da sua empresa.",
            color = TextSecondary,
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 8.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Novo Ambiente */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = AccentBlue),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(vertical = 12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Novo Ambiente", fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Lista de Ambientes
        EnvironmentCard(
            name = "Armazem Nº1",
            description = "Armazem azul",
            tag = "arejado",
            totalDevices = 0,
            onDetailsClick = onEnvironmentClick
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        EnvironmentCard(
            name = "Geladeira Nº1",
            description = "Sem descrição",
            tag = "frio",
            totalDevices = 0,
            onDetailsClick = onEnvironmentClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        EnvironmentCard(
            name = "teste",
            description = "Sem descrição",
            tag = "teste",
            totalDevices = 0,
            onDetailsClick = onEnvironmentClick
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}
