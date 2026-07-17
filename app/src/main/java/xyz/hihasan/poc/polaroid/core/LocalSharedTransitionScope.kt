package xyz.hihasan.poc.polaroid.core

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.staticCompositionLocalOf

@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = staticCompositionLocalOf<SharedTransitionScope> {
    error("LocalSharedTransitionScope not provided — screen composed outside MainScreen's SharedTransitionLayout")
}
