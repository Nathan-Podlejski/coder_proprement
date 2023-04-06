package com.example.coder_proprement.api

import fr.iem.api.ApiClient
import fr.iem.api.MarvelRetrofitInterface
import fr.iem.model.Comic
import fr.iem.model.ComicCreators
import fr.iem.model.MarvelCharacter
import fr.iem.model.MarvelResponse
import retrofit2.Call
import retrofit2.http.Query

interface MarvelRepository {
    suspend fun getAllComics(time: String, apikey:String, hash: String): Call<MarvelResponse<Comic>>
    suspend fun getComicById(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<Comic>>
    suspend fun getCharsInComic(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<MarvelCharacter>>
    suspend fun getComicCreator(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<ComicCreators>>

    companion object {
        fun newInstance(): MarvelRepository {
            return MarvelRepositoryImpl()
        }
    }
}

private class MarvelRepositoryImpl: MarvelRepository {

    private val service = ApiClient.apiService

    override suspend fun getAllComics(time: String, apikey:String, hash: String): Call<MarvelResponse<Comic>> {
        return service.getAllComics(time, apikey, hash)
    }

    override suspend fun getComicById(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<Comic>> {
        return service.getComicById(id, time, apikey, hash)
    }

    override suspend fun getCharsInComic(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<MarvelCharacter>> {
        return service.getCharsInComic(id, time, apikey, hash)
    }

    override suspend fun getComicCreator(id: String, time: String, apikey:String, hash: String): Call<MarvelResponse<ComicCreators>> {
        return service.getComicCreator(id, time, apikey, hash)
    }

}
