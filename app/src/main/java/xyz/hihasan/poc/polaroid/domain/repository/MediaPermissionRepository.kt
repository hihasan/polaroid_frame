package xyz.hihasan.poc.polaroid.domain.repository

import xyz.hihasan.poc.polaroid.domain.model.MediaPermissionStatus

interface MediaPermissionRepository {
    fun getStatus(): MediaPermissionStatus

    fun getRequiredPermissions(): List<String>
}
