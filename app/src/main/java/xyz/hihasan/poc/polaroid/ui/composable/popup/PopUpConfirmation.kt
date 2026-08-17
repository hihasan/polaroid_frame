package xyz.hihasan.poc.polaroid.ui.composable.popup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import xyz.hihasan.poc.polaroid.ui.composable.button.PolaroidFilledButton
import xyz.hihasan.poc.polaroid.ui.composable.button.PolaroidOutlinedButton
import xyz.hihasan.poc.polaroid.ui.theme.PolaroidTheme

private val ScrimColor = Color.Black.copy(alpha = 0.6f)

@Composable
fun PopUpConfirmation(
    text: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
    confirmText: String = "Confirm",
    dismissText: String = "Cancel",
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(ScrimColor),
            contentAlignment = Alignment.Center,
        ) {
            Surface(
                modifier = modifier
                    .padding(32.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                tonalElevation = 4.dp,
                shadowElevation = 12.dp,
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                ) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        PolaroidOutlinedButton(
                            text = dismissText,
                            onClick = onDismiss,
                            modifier = Modifier.weight(1f),
                        )
                        PolaroidFilledButton(
                            text = confirmText,
                            onClick = onConfirm,
                            modifier = Modifier.weight(1f),
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PopUpConfirmationPreview() {
    PolaroidTheme {
        PopUpConfirmation(
            text = "Discard this photo?",
            onConfirm = {},
            onDismiss = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PopUpConfirmationLongTextPreview() {
    PolaroidTheme {
        PopUpConfirmation(
            text = "Are you sure you want to delete this polaroid frame? This action cannot be undone.",
            onConfirm = {},
            onDismiss = {},
            confirmText = "Delete",
        )
    }
}
