package org.d3if0070.diaryme.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import org.d3if0070.diaryme.model.ImageDeleteResponse
import org.d3if0070.diaryme.model.ImageGetResponse
import org.d3if0070.diaryme.model.ImagePostResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

private const val BASE_URL_IMAGE = "https://api.imgur.com/3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()


private val retrofit_image = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_IMAGE)
    .build()


interface ApiImageService {
    @Multipart
    @POST("image/")
    suspend fun uploadImg(
        @Header("Authorization") clientId: String = "Client-ID 2a5b156b20f4aed",
        @Part image: MultipartBody.Part
    ): ImagePostResponse

    @GET("image/{imageHash}")
    suspend fun getImg(
        @Header("Authorization") clientId: String = "Client-ID 2a5b156b20f4aed",
        @Path("imageHash") imageHash: String
    ): ImageGetResponse

    @DELETE("image/{imageDeleteHash}")
    suspend fun deleteImg(
        @Header("Authorization") clientId: String = "Client-ID 2a5b156b20f4aed",
        @Path("imageDeleteHash") deleteHash: String
    ): ImageDeleteResponse
}

object ImageApi {
    val imgService: ApiImageService by lazy {
        retrofit_image.create(ApiImageService::class.java)
    }

    fun getImageUrl(imageId: String): String{
        return "https://i.imgur.com/$imageId"
    }
}