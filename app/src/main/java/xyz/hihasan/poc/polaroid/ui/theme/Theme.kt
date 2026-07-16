package xyz.hihasan.poc.polaroid.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Fixed theme: background is always an off-white shade of paper, regardless
// of system light/dark setting, so dynamic color and dark mode are not used.
private val AppColorScheme = lightColorScheme(
    primary = Green,
    onPrimary = TextDark,
    primaryContainer = GreenLight,
    onPrimaryContainer = GreenDark,
    background = OffWhite,
    onBackground = TextDark,
    surface = OffWhite,
    onSurface = TextDark,
    surfaceVariant = OffWhiteDim,
    onSurfaceVariant = TextDark
)

@Composable
fun PolaroidTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography = Typography,
        content = content
    )
}
