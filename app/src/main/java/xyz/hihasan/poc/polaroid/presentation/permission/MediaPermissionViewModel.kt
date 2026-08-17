package xyz.hihasan.poc.polaroid.presentation.permission

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import xyz.hihasan.poc.polaroid.domain.model.MediaPermissionStatus
import xyz.hihasan.poc.polaroid.domain.usecase.GetMediaPermissionStatusUseCase
import xyz.hihasan.poc.polaroid.domain.usecase.GetRequiredMediaPermissionsUseCase
import javax.inject.Inject

@HiltViewModel
class MediaPermissionViewModel
    @Inject
    constructor(
        private val getMediaPermissionStatusUseCase: GetMediaPermissionStatusUseCase,
        getRequiredMediaPermissionsUseCase: GetRequiredMediaPermissionsUseCase,
    ) : ViewModel() {
        val requiredPermissions: List<String> = getRequiredMediaPermissionsUseCase()

        private val _status = MutableStateFlow(getMediaPermissionStatusUseCase())
        val status: StateFlow<MediaPermissionStatus> = _status.asStateFlow()

        fun refreshStatus() {
            _status.value = getMediaPermissionStatusUseCase()
        }
    }
