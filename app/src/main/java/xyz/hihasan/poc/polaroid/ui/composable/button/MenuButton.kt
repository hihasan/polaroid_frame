package xyz.hihasan.poc.polaroid.ui.composable.button

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandCircleDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme
import xyz.hihasan.poc.polaroid.ui.theme.White

@Composable
fun MenuButton(){
    Row(
        modifier = Modifier.clip(shape = RoundedCornerShape(35.dp)).background(color = White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Select",
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(12.dp)
        )

        Icon(
            Icons.Outlined.ExpandCircleDown,
            contentDescription = "more info",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@OptIn(ExperimentalSharedTransitionApi::class)
@Preview(showBackground = true)
@Composable
private fun MenuButtonPreview() {
    PolaroidTheme {
        MenuButton()
    }
}