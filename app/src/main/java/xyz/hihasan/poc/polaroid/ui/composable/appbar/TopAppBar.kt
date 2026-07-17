package xyz.hihasan.poc.polaroid.ui.composable.appbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import xyz.hihasan.poc.polaroid.R
import xyz.hihasan.poc.polaroid.core.LocalSharedTransitionScope
import xyz.hihasan.poc.polaroid.presentation.navigation.AppNameSharedKey
import xyz.hihasan.poc.polaroid.ui.theme.Green

private const val CollapseTransitionDurationMillis = 600

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    collapsed: Boolean = false,
    actions: @Composable () -> Unit = {},
) {
    val sharedTransitionScope = LocalSharedTransitionScope.current
    val nameHorizontalBias by animateFloatAsState(
        targetValue = if (collapsed) -1f else 0f,
        animationSpec = tween(durationMillis = CollapseTransitionDurationMillis),
        label = "AppNameHorizontalBias"
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        with(sharedTransitionScope) {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                color = Green,
                modifier = Modifier
                    .align(BiasAlignment(horizontalBias = nameHorizontalBias, verticalBias = 0f))
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = AppNameSharedKey),
                        animatedVisibilityScope = LocalNavAnimatedContentScope.current
                    )
            )
        }

        AnimatedVisibility(
            visible = collapsed,
            enter = fadeIn(tween(CollapseTransitionDurationMillis)) +
                slideInHorizontally(tween(CollapseTransitionDurationMillis)) { it / 2 },
            exit = fadeOut(tween(CollapseTransitionDurationMillis)),
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            actions()
        }
    }
}
