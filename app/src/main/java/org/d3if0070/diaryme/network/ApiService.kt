package org.d3if0070.diaryme.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0070.diaryme.model.MessageResponse
import org.d3if0070.diaryme.model.Post
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://diary-me.vercel.app/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface UserApi {
    @Multipart
    @POST("diaries/")
    suspend fun addData(
        @Part("description") title: RequestBody,
        @Part("location") type: RequestBody,
        @Part("user_email") userEmail: RequestBody,
        @Part file: MultipartBody.Part
    ): Post

    @GET("diaries/")
    suspend fun getAllData(
        @Query("email") email: String,
    ): List<Post>

    @DELETE("diaries/{post_id}")
    suspend fun deleteData(
        @Path("post_id") id: Int,
        @Query("email") email: String
    ): MessageResponse
}


object Api {
    val userService: UserApi by lazy {
        retrofit.create(UserApi::class.java)
    }

    fun getImageUrl(imageId: String): String{
        return BASE_URL + "diaries/images/$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }