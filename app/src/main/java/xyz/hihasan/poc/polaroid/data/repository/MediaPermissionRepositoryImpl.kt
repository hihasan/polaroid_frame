package xyz.hihasan.poc.polaroid.data.repository

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import xyz.hihasan.poc.polaroid.domain.model.MediaPermissionStatus
import xyz.hihasan.poc.polaroid.domain.repository.MediaPermissionRepository
import javax.inject.Inject

class MediaPermissionRepositoryImpl
    @Inject
    constructor(
        @ApplicationContext private val context: Context,
    ) : MediaPermissionRepository {
        override fun getStatus(): MediaPermissionStatus =
            when {
                isGranted(Manifest.permission.READ_MEDIA_IMAGES) -> MediaPermissionStatus.Granted
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE &&
                    isGranted(Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED) ->
                    MediaPermissionStatus.PartiallyGranted
                else -> MediaPermissionStatus.Denied
            }

        override fun getRequiredPermissions(): List<String> =
            buildList {
                add(Manifest.permission.READ_MEDIA_IMAGES)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
                    add(Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED)
                }
            }

        private fun isGranted(permission: String): Boolean =
            ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
    }
