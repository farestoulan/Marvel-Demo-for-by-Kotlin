package ModelClasses

import com.google.gson.annotations.SerializedName


class ThumbnailModel(
    @SerializedName("path") var path: String, @SerializedName(
        "extension"
    ) var extension: String
)