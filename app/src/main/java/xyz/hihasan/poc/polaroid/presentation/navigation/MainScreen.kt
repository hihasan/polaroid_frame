package xyz.hihasan.poc.polaroid.presentation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import xyz.hihasan.poc.polaroid.core.LocalSharedTransitionScope
import xyz.hihasan.poc.polaroid.presentation.editor.EditorScreen
import xyz.hihasan.poc.polaroid.presentation.home.HomeScreen
import xyz.hihasan.poc.polaroid.presentation.splash.SplashScreen

internal const val AppNameSharedKey = "app_name"
private const val SplashDurationMillis = 3000L

@Serializable
internal data object Splash : NavKey

@Serializable
internal data object Home : NavKey

@Serializable
internal data object Editor : NavKey

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(Splash)

    LaunchedEffect(Unit) {
        delay(SplashDurationMillis)
        // Splash -> Home is one-way: push Home, then drop Splash so back exits the app
        // instead of returning to it.
        backStack.add(Home)
        backStack.removeAt(0)
    }

    SharedTransitionLayout(modifier = modifier.fillMaxSize()) {
        CompositionLocalProvider(LocalSharedTransitionScope provides this) {
            NavDisplay(
                backStack = backStack,
                onBack = { backStack.removeAt(backStack.lastIndex) },
                sharedTransitionScope = this@SharedTransitionLayout,
                entryProvider =
                    entryProvider {
                        entry<Splash> { SplashScreen() }
                        entry<Home> { HomeScreen(onAddPhotoClick = { backStack.add(Editor) }) }
                        entry<Editor> { EditorScreen(onBackClick = { backStack.removeAt(backStack.lastIndex) }) }
                    },
            )
        }
    }
}
