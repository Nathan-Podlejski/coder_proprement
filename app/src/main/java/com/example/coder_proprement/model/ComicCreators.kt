package fr.iem.model

import com.google.gson.annotations.SerializedName

data class ComicCreators(

    @SerializedName("id"          ) var id          : Int?            = null,
    @SerializedName("firstName"   ) var firstName   : String?         = null,
    @SerializedName("middleName"  ) var middleName  : String?         = null,
    @SerializedName("lastName"    ) var lastName    : String?         = null,
    @SerializedName("suffix"      ) var suffix      : String?         = null,
    @SerializedName("fullName"    ) var fullName    : String?         = null,
    @SerializedName("modified"    ) var modified    : String?         = null,
    @SerializedName("thumbnail"   ) var thumbnail   : ThumbnailComic? = ThumbnailComic(),
    @SerializedName("resourceURI" ) var resourceURI : String?         = null,
    @SerializedName("comics"      ) var comics      : Comic?          = null,
    @SerializedName("series"      ) var series      : SeriesComic?    = SeriesComic(),
    @SerializedName("stories"     ) var stories     : StoriesComic    = StoriesComic(),
    @SerializedName("events"      ) var events      : EventsComicCreator?    = EventsComicCreator(),
    @SerializedName("urls"        ) var urls        : ArrayList<Urls> = arrayListOf()
)

data class EventsComicCreator (
    @SerializedName("available"     ) var available     : Int?              = null,
    @SerializedName("collectionURI" ) var collectionURI : String?           = null,
    @SerializedName("items"         ) var items         : ArrayList<Variants> = arrayListOf(),
    @SerializedName("returned"      ) var returned      : Int?              = null
)