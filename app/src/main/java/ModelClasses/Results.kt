package ModelClasses

import com.google.gson.annotations.SerializedName


class Results {
    @JvmField
    @SerializedName("results")
    var results: MutableList<ListModelClass?>? = null
}