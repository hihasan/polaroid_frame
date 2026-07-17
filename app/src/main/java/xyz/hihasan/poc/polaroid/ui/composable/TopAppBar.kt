package xyz.hihasan.poc.polaroid.ui.composable

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import xyz.hihasan.poc.polaroid.R
import xyz.hihasan.poc.polaroid.core.LocalSharedTransitionScope
import xyz.hihasan.poc.polaroid.presentation.navigation.AppNameSharedKey
import xyz.hihasan.poc.polaroid.ui.theme.Green

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    val sharedTransitionScope = LocalSharedTransitionScope.current
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.headlineMedium,
        color = Green,
        modifier = with(sharedTransitionScope) {
            modifier.sharedBounds(
                sharedContentState = rememberSharedContentState(key = AppNameSharedKey),
                animatedVisibilityScope = LocalNavAnimatedContentScope.current
            )
        }
    )
}
