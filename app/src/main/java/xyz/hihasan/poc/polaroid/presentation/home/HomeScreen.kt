package xyz.hihasan.poc.polaroid.presentation.home

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.hihasan.poc.polaroid.R
import xyz.hihasan.poc.polaroid.ui.composable.TopAppBar
import xyz.hihasan.poc.polaroid.ui.theme.Green
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAddPhotoClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        TopAppBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .statusBarsPadding()
                .padding(top = 12.dp)
        )

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
