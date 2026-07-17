package xyz.hihasan.poc.polaroid.ui.composable.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.hihasan.poc.polaroid.ui.composable.appbar.TopAppBar

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    collapsed: Boolean = false,
    actions: @Composable () -> Unit = {},
    content: @Composable BoxScope.() -> Unit = {},
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
                .padding(top = 12.dp),
            collapsed = collapsed,
            actions = actions
        )

        content()
    }
}
