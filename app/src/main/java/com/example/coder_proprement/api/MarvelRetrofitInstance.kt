package fr.iem.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL: String = "https://gateway.marvel.com:443"

//    const val TS = timestamp //milisecond
//    const val APIKEY = publicKey
//    const val HASH = MD5 hash of (ts + privateKey + publicKey)

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiService :  MarvelRetrofitInterface by lazy{
        retrofit.create(MarvelRetrofitInterface::class.java)
    }
}