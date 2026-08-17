package xyz.hihasan.poc.polaroid.domain.usecase

import xyz.hihasan.poc.polaroid.domain.model.MediaPermissionStatus
import xyz.hihasan.poc.polaroid.domain.repository.MediaPermissionRepository
import javax.inject.Inject

class GetMediaPermissionStatusUseCase
    @Inject
    constructor(
        private val repository: MediaPermissionRepository,
    ) {
        operator fun invoke(): MediaPermissionStatus = repository.getStatus()
    }
