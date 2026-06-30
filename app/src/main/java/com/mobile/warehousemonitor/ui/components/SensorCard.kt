package com.mobile.warehousemonitor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.warehousemonitor.ui.theme.CardBackground
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

@Composable
fun SensorCard(
    label: String,
    value: String,
    indicatorColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(85.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(CardBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(5.dp)
                .background(indicatorColor)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                color = TextSecondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                color = TextPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}