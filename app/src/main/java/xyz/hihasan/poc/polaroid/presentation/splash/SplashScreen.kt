package xyz.hihasan.poc.polaroid.presentation.splash

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import xyz.hihasan.poc.polaroid.R
import xyz.hihasan.poc.polaroid.core.LocalSharedTransitionScope
import xyz.hihasan.poc.polaroid.presentation.navigation.AppNameSharedKey
import xyz.hihasan.poc.polaroid.presentation.permission.MediaPermissionEffect
import xyz.hihasan.poc.polaroid.ui.theme.Green
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val sharedTransitionScope = LocalSharedTransitionScope.current

    MediaPermissionEffect()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Green),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White,
            modifier = with(sharedTransitionScope) {
                Modifier.sharedBounds(
                    sharedContentState = rememberSharedContentState(key = AppNameSharedKey),
                    animatedVisibilityScope = LocalNavAnimatedContentScope.current
                )
            }
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SplashScreenPreview() {
    PolaroidTheme {
        SplashScreen()
    }
}
