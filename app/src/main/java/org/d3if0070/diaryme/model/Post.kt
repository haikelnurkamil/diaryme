package org.d3if0070.diaryme.model

data class Post(
    val post_id: Int,
    val user_email: String,
    val description: String,
    val location: String,
    val created_at: String,
    val image_id: String,
    val delete_hash: String
)


data class PostCreate(
    val user_email: String,
    val description: String,
    val location: String,
    val image_id: String,
    val delete_hash: String
)
