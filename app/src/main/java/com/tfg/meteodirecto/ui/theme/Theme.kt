package com.tfg.meteodirecto.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Darkprimary,
    onPrimary = DarkonPrimary,
    primaryContainer = DarkprimaryContainer,
    onPrimaryContainer = DarkonPrimaryContainer,

    inversePrimary = DarkinversePrimary,

    secondary = Darksecondary,
    onSecondary = DarkonSecondary,
    secondaryContainer = DarksecondaryContainer,
    onSecondaryContainer = DarkonSecondaryContainer,

    tertiary = Darktertiary,
    onTertiary = DarkonTertiary,
    tertiaryContainer = DarktertiaryContainer,
    onTertiaryContainer = DarkonTertiaryContainer,

    background = Darkprimary,

    surface = Darksurface,
    onSurface = DarkonSurface,
    surfaceVariant = DarksurfaceVariant,
    onSurfaceVariant = DarkonSurfaceVariant,

    surfaceTint = DarksurfaceTint,
    inverseSurface = DarkinverseSurface,
    inverseOnSurface = DarkinverseOnSurface,

    error = Darkerror,
    onError = DarkonError,
    errorContainer = DarkerrorContainer,
    onErrorContainer = DarkonErrorContainer,

    outline = Darkoutline,
    outlineVariant = DarkoutlineVariant,

    scrim = Darkscrim
)

private val LightColorScheme = lightColorScheme(
    primary = Lightprimary ,
    onPrimary = LightonPrimary ,
    primaryContainer = LightprimaryContainer ,
    onPrimaryContainer = LightonPrimaryContainer ,

    inversePrimary = LightinversePrimary,

    secondary = Lightsecondary ,
    onSecondary = LightonSecondary  ,
    secondaryContainer = LightsecondaryContainer ,
    onSecondaryContainer = LightonSecondaryContainer,

    tertiary = Lighttertiary ,
    onTertiary = LightonTertiary ,
    tertiaryContainer = LighttertiaryContainer,
    onTertiaryContainer = LightonTertiaryContainer,

    surface =  Lightsurface,
    onSurface =  LightonSurface,
    surfaceVariant = LightsurfaceVariant,
    onSurfaceVariant = LightonSurfaceVariant,
    surfaceTint = LightsurfaceTint,
    inverseSurface = LightinverseSurface,
    inverseOnSurface = LightinverseOnSurface,

    background = Lightprimary,

    error = Lighterror ,
    onError = LightonError,
    errorContainer = LighterrorContainer,
    onErrorContainer = LightonErrorContainer,

    outline = Lightoutline ,
    outlineVariant = LightoutlineVariant,

    scrim = Lightscrim

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun MeteoDirectoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography2,
        content = content
    )
}