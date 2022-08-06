package Database

import ModelClasses.DataModelClass
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ModelClasses.ApiInterface
import retrofit2.Call
import retrofit2.Callback

class RemoteDataSource {
    private var volumesResponseLiveData: MutableLiveData<DataModelClass>? = null

    companion object {
        private const val BASE_URL = "https://gateway.marvel.com/"
    }


    fun remoteData(callback: Callback<DataModelClass?>): Call<DataModelClass?>? {
        volumesResponseLiveData = MutableLiveData()
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiInterface = retrofit.create(ApiInterface::class.java)
        val call = apiInterface.getPhoto()
        call?.enqueue(callback)
        return call
    }


}