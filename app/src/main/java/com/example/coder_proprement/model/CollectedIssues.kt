package fr.iem.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CollectedIssue (
    @SerializedName("resourceURI") var resourceURI: String? = null,
    @SerializedName("name") var name: String? = null
)
