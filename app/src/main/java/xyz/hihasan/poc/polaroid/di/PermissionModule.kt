package xyz.hihasan.poc.polaroid.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.hihasan.poc.polaroid.data.repository.MediaPermissionRepositoryImpl
import xyz.hihasan.poc.polaroid.domain.repository.MediaPermissionRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class PermissionModule {
    @Binds
    abstract fun bindMediaPermissionRepository(impl: MediaPermissionRepositoryImpl): MediaPermissionRepository
}
