package xyz.hihasan.poc.polaroid.presentation.permission

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import xyz.hihasan.poc.polaroid.domain.model.MediaPermissionStatus

/**
 * Requests the app's media-read permission once, if it hasn't already been granted.
 * Fire-and-forget side effect with no UI of its own — safe to drop into any screen
 * that needs photo-library access (e.g. Splash, Home).
 */
@Composable
fun MediaPermissionEffect(viewModel: MediaPermissionViewModel = hiltViewModel()) {
    val status by viewModel.status.collectAsState()

    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            viewModel.refreshStatus()
        }

    LaunchedEffect(Unit) {
        if (status != MediaPermissionStatus.Granted) {
            launcher.launch(viewModel.requiredPermissions.toTypedArray())
        }
    }
}
