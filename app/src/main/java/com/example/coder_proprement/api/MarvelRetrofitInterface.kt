package fr.iem.api

import fr.iem.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface MarvelRetrofitInterface {
    //ts={time}&apikey={key}&hash={hash}
    @GET("/v1/public/comics")
    fun getAllComics (@Query("ts") time: String, @Query("apikey") apikey:String,
                      @Query("hash") hash: String, @Query("offset") offset: String):
            Call<MarvelResponse<Comic>>

    @GET("/v1/public/comics/{comics_id}")
    fun getComicById(@Path("comics_id") id: String, @Query("ts") time: String, @Query("apikey") apikey:String,
                     @Query("hash") hash: String):
            Call<MarvelResponse<Comic>>

    @GET("/v1/public/comics/{comics_id}/characters")
    fun getCharsInComic(@Path("comics_id") id: String, @Query("ts") time: String, @Query("apikey") apikey:String,
                        @Query("hash") hash: String):
            Call<MarvelResponse<MarvelCharacter>>

    @GET("/v1/public/comics/{comics_id}/creators")
    fun getComicCreator(@Path("comics_id") id: String, @Query("ts") time: String, @Query("apikey") apikey:String,
                        @Query("hash") hash: String):
            Call<MarvelResponse<ComicCreators>>



}