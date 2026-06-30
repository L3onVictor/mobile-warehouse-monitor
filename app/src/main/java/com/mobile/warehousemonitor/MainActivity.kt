package com.mobile.warehousemonitor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mobile.warehousemonitor.ui.main.MainScreen
import com.mobile.warehousemonitor.ui.theme.WarehouseMonitorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarehouseMonitorTheme {
                MainScreen()
            }
        }
    }
}