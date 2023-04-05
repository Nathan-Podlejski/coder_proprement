package fr.iem.model

import com.google.gson.annotations.SerializedName

data class Comic(

    @SerializedName("id"                 ) var id                 : Int?                = null,
    @SerializedName("digitalId"          ) var digitalId          : Int?                = null,
    @SerializedName("title"              ) var title              : String?             = null,
    @SerializedName("issueNumber"        ) var issueNumber        : Int?                = null,
    @SerializedName("variantDescription" ) var variantDescription : String?             = null,
    @SerializedName("description"        ) var description        : String?             = null,
    @SerializedName("modified"           ) var modified           : String?             = null,
    @SerializedName("isbn"               ) var isbn               : String?             = null,
    @SerializedName("upc"                ) var upc                : String?             = null,
    @SerializedName("diamondCode"        ) var diamondCode        : String?             = null,
    @SerializedName("ean"                ) var ean                : String?             = null,
    @SerializedName("issn"               ) var issn               : String?             = null,
    @SerializedName("format"             ) var format             : String?             = null,
    @SerializedName("pageCount"          ) var pageCount          : Int?                = null,
    @SerializedName("textObjects"        ) var textObjects        : ArrayList<TextObjects> = arrayListOf(),
    @SerializedName("resourceURI"        ) var resourceURI        : String?             = null,
    @SerializedName("urls"               ) var urls               : ArrayList<Urls>     = arrayListOf(),
    @SerializedName("series"             ) var series             : SeriesComic?        = SeriesComic(),
    @SerializedName("variants"           ) var variants           : ArrayList<Variants> = arrayListOf(),
    @SerializedName("collections"        ) var collections        : ArrayList<Variants>   = arrayListOf(),
    @SerializedName("collectedIssues"    ) var collectedIssues    : ArrayList<Variants> = arrayListOf(),
    @SerializedName("dates"              ) var dates              : ArrayList<Dates>    = arrayListOf(),
    @SerializedName("prices"             ) var prices             : ArrayList<Prices>   = arrayListOf(),
    @SerializedName("thumbnail"          ) var thumbnail          : ThumbnailComic?     = ThumbnailComic(),
    @SerializedName("images"             ) var images             : ArrayList<ThumbnailComic> = arrayListOf(),
    @SerializedName("creators"           ) var creators           : Creators?           = Creators(),
    @SerializedName("characters"         ) var characters         : Characters?         = Characters(),
    @SerializedName("stories"            ) var stories            : StoriesComic?       = StoriesComic(),
    @SerializedName("events"             ) var events             : EventsComic?        = EventsComic()
)

data class Urls (
    @SerializedName("type" ) var type : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

data class Variants (
    @SerializedName("resourceURI" ) var resourceURI : String? = null,
    @SerializedName("name"        ) var name        : String? = null
)


data class Dates (
    @SerializedName("type" ) var type : String? = null,
    @SerializedName("date" ) var date : String? = null
)

data class Prices (
    @SerializedName("type"  ) var type  : String? = null,
    @SerializedName("price" ) var price : Double?    = null
)

data class Creators (
    @SerializedName("available"     ) var available     : Int?             = null,
    @SerializedName("collectionURI" ) var collectionURI : String?          = null,
    @SerializedName("items"         ) var items         : ArrayList<CreatorSummary> = arrayListOf(),
    @SerializedName("returned"      ) var returned      : Int?             = null
)

data class CreatorSummary (
    @SerializedName("resourceURI" ) var resourceURI : String? = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("role"        ) var role        : String? = null
)


data class Characters (
    @SerializedName("available"     ) var available     : Int?              = null,
    @SerializedName("collectionURI" ) var collectionURI : String?           = null,
    @SerializedName("items"         ) var items         : ArrayList<Variants> = arrayListOf(),
    @SerializedName("returned"      ) var returned      : Int?              = null
)

data class StoriesComic (
    @SerializedName("available"     ) var available     : Int?             = null,
    @SerializedName("collectionURI" ) var collectionURI : String?          = null,
    @SerializedName("items"         ) var items         : ArrayList<StorySummary> = arrayListOf(),
    @SerializedName("returned"      ) var returned      : Int?             = null
)

data class StorySummary (
    @SerializedName("resourceURI" ) var resourceURI : String? = null,
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("type"        ) var type        : String? = null
)

data class EventsComic (
    @SerializedName("available"     ) var available     : Int?              = null,
    @SerializedName("collectionURI" ) var collectionURI : String?           = null,
    @SerializedName("items"         ) var items         : ArrayList<String> = arrayListOf(),
    @SerializedName("returned"      ) var returned      : Int?              = null
)

data class SeriesComic (
    @SerializedName("resourceURI" ) var resourceURI : String? = null,
    @SerializedName("name"        ) var name        : String? = null
)

data class ThumbnailComic (
    @SerializedName("path"      ) var path      : String? = null,
    @SerializedName("extension" ) var extension : String? = null
)

data class TextObjects (
    @SerializedName("type"      ) var type      : String? = null,
    @SerializedName("language"  ) var language  : String? = null,
    @SerializedName("text"      ) var text      : String? = null
)