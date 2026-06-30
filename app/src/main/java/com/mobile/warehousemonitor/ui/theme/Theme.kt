package com.mobile.warehousemonitor.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Forçamos o esquema de cores escuro a usar a nossa paleta customizada
private val DarkColorScheme = darkColorScheme(
    primary = AccentBlue,
    secondary = CardBackground,
    background = BackgroundDark,
    surface = CardBackground,
    onPrimary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

// Opcional: Caso o usuário mude o celular para modo claro, mantemos uma consistência ou usamos as mesmas
private val LightColorScheme = lightColorScheme(
    primary = AccentBlue,
    secondary = CardBackground,
    background = BackgroundDark,
    surface = CardBackground,
    onPrimary = TextPrimary,
    onBackground = TextPrimary,
    onSurface = TextPrimary

)

@Composable
fun WarehouseMonitorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Desativamos o dynamicColor por padrão para garantir que o app use as cores do seu design
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}