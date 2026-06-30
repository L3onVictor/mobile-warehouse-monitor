package com.mobile.warehousemonitor.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.mobile.warehousemonitor.ui.alerts.AlertsScreen
import com.mobile.warehousemonitor.ui.dashboard.MainDashboardScreen
import com.mobile.warehousemonitor.ui.devices.DeviceDetailScreen
import com.mobile.warehousemonitor.ui.devices.DeviceMonitoringScreen
import com.mobile.warehousemonitor.ui.devices.DevicesScreen
import com.mobile.warehousemonitor.ui.environments.EnvironmentDetailScreen
import com.mobile.warehousemonitor.ui.environments.EnvironmentsScreen
import com.mobile.warehousemonitor.ui.theme.AccentBlue
import com.mobile.warehousemonitor.ui.theme.CardBackground
import com.mobile.warehousemonitor.ui.theme.TextPrimary
import com.mobile.warehousemonitor.ui.theme.TextSecondary

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Dashboard : BottomNavItem("dashboard", Icons.Default.Home, "Dashboard")
    object Environments : BottomNavItem("environments", Icons.AutoMirrored.Filled.List, "Ambientes")
    object Devices : BottomNavItem("devices", Icons.Default.Build, "Dispositivos")
    object Alerts : BottomNavItem("alerts", Icons.Default.Notifications, "Alertas")
}

@Composable
fun MainScreen() {
    var selectedItem by remember { mutableStateOf<BottomNavItem>(BottomNavItem.Dashboard) }
    var showingEnvironmentDetail by remember { mutableStateOf(false) }
    var monitoringDeviceName by remember { mutableStateOf<String?>(null) }
    var showingDeviceDetailName by remember { mutableStateOf<String?>(null) }
    
    val items = listOf(
        BottomNavItem.Dashboard,
        BottomNavItem.Environments,
        BottomNavItem.Devices,
        BottomNavItem.Alerts
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = CardBackground,
                contentColor = TextSecondary
            ) {
                items.forEach { item ->
                    val isSelected = selectedItem == item
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = { 
                            selectedItem = item
                            showingEnvironmentDetail = false
                            monitoringDeviceName = null
                            showingDeviceDetailName = null
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label
                            )
                        },
                        label = {
                            Text(
                                text = item.label,
                                color = if (isSelected) TextPrimary else TextSecondary
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = AccentBlue,
                            unselectedIconColor = TextSecondary,
                            indicatorColor = CardBackground // Remove o círculo de destaque padrão
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
        ) {
            when (selectedItem) {
                is BottomNavItem.Dashboard -> MainDashboardScreen()
                is BottomNavItem.Environments -> {
                    if (showingEnvironmentDetail) {
                        EnvironmentDetailScreen(onBack = { showingEnvironmentDetail = false })
                    } else {
                        EnvironmentsScreen(onEnvironmentClick = { showingEnvironmentDetail = true })
                    }
                }
                is BottomNavItem.Devices -> {
                    val mDeviceName = monitoringDeviceName
                    val dDeviceName = showingDeviceDetailName
                    
                    if (mDeviceName != null) {
                        DeviceMonitoringScreen(
                            deviceName = mDeviceName,
                            onBack = { monitoringDeviceName = null }
                        )
                    } else if (dDeviceName != null) {
                        DeviceDetailScreen(
                            deviceName = dDeviceName,
                            onBack = { showingDeviceDetailName = null }
                        )
                    } else {
                        DevicesScreen(
                            onMonitorClick = { monitoringDeviceName = it },
                            onDetailsClick = { showingDeviceDetailName = it }
                        )
                    }
                }
                is BottomNavItem.Alerts -> AlertsScreen()
            }
        }
    }
}
