package xyz.hihasan.poc.polaroid.ui.composable.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import xyz.hihasan.poc.polaroid.ui.theme.Green
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme
import xyz.hihasan.poc.polaroid.ui.theme.White

private val PolaroidButtonShape = RoundedCornerShape(5.dp)

@Composable
fun PolaroidAppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = PolaroidButtonShape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    border: BorderStroke? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        border = border,
    ) {
        Text(text = text)
    }
}

@Composable
fun PolaroidFilledButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    PolaroidAppButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Green,
            contentColor = White,
        ),
    )
}

@Composable
fun PolaroidOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    PolaroidAppButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Green,
        ),
    )
}

@Preview(showBackground = false)
@Composable
private fun PolaroidFilledButtonPreview() {
    PolaroidTheme {
        PolaroidFilledButton(text = "Save", onClick = {})
    }
}

@Preview(showBackground = false)
@Composable
private fun PolaroidOutlinedButtonPreview() {
    PolaroidTheme {
        PolaroidOutlinedButton(text = "Cancel", onClick = {})
    }
}
