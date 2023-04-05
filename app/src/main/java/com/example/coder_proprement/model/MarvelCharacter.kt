package fr.iem.model

import com.google.gson.annotations.SerializedName

data class MarvelCharacter(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("thumbnail") val thumbnail: Thumbnail,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("comics") val comicsCharacter: ComicsCharacter,
    @SerializedName("series") val series: Series,
    @SerializedName("stories") val stories: Stories,
    @SerializedName("events") val events: Events
)

data class Thumbnail (
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: String
)

data class ComicsCharacter (
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String
)

data class Series (
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String
)

data class Stories (
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("returned") val returned: Int
)

data class Events (
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("returned") val returned: Int
)
