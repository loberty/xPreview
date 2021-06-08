package com.smart.preview

data class MediaEntry(val imageUrl: String?, val videoUrl: String?) {
    val isImage: Boolean
        get() = imageUrl != null && imageUrl.isNotEmpty()

    val uri: String?
        get() = if (isImage) imageUrl else videoUrl
}