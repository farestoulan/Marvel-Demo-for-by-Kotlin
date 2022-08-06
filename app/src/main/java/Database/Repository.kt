package Database


import ModelClasses.DataModelClass
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val remoteData: RemoteDataSource, private val localData: LocalDataSource) {
    fun getData(): MutableLiveData<DataModelClass?> {
        val res = MutableLiveData<DataModelClass?>()
        if (localData.getLocalData() != null) {
            res.postValue(localData.getLocalData())
        } else {

            remoteData.remoteData(object : Callback<DataModelClass?> {
                override fun onResponse(
                    call: Call<DataModelClass?>,
                    response: Response<DataModelClass?>
                ) {
                    if (response.body() != null) {
                        localData.insertLocalData(response.body())
                        res.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DataModelClass?>, t: Throwable) {
                    res.postValue(null)
                }
            })
        }
        return res
    }
}