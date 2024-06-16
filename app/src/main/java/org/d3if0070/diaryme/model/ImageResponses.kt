package org.d3if0070.diaryme.model
data class ImagePostResponse(
    val data: ImageData,
    val success: Boolean
)


data class ImageData(
    val id: String,
    val link: String,
    val type: String,
    val deletehash: String? = null,
)

data class ImageGetResponse(
    val data: ImageData
)

data class ImageDeleteResponse(
    val success: Boolean
)


