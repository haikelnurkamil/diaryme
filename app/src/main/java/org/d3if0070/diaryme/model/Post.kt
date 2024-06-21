package org.d3if0070.diaryme.model

data class Post(
    val user_email: String,
    val created_at: String,
    val location: String,
    val description: String,
    val post_id: Int,
    val image_id: String
)
