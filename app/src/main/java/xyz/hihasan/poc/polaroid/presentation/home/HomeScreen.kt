package xyz.hihasan.poc.polaroid.presentation.home

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import xyz.hihasan.poc.polaroid.R
import xyz.hihasan.poc.polaroid.ui.composable.button.MenuButton
import xyz.hihasan.poc.polaroid.ui.composable.screen.BaseScreen
import xyz.hihasan.poc.polaroid.ui.theme.Green
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme

private const val TopAppBarCollapseDelayMillis = 3000L

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddPhotoClick: () -> Unit = {},
) {
    var isTopAppBarCollapsed by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(TopAppBarCollapseDelayMillis)
        isTopAppBarCollapsed = true
    }

    BaseScreen(
        modifier = modifier,
        collapsed = isTopAppBarCollapsed,
        actions = { MenuButton() }
    ) {
        FloatingActionButton(
            onClick = onAddPhotoClick,
            containerColor = Green,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .navigationBarsPadding()
                .padding(24.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.AddAPhoto,
                contentDescription = stringResource(R.string.add_photo)
            )
        }
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    PolaroidTheme {
        HomeScreen()
    }
}
