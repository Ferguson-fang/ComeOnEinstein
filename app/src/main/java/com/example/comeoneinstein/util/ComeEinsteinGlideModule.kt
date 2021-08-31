package com.example.comeoneinstein.util

import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
@GlideModule
class ComeEinsteinGlideModule : AppGlideModule() {
    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}