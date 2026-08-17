package xyz.hihasan.poc.polaroid.domain.usecase

import xyz.hihasan.poc.polaroid.domain.repository.MediaPermissionRepository
import javax.inject.Inject

class GetRequiredMediaPermissionsUseCase
    @Inject
    constructor(
        private val repository: MediaPermissionRepository,
    ) {
        operator fun invoke(): List<String> = repository.getRequiredPermissions()
    }
