package Database

import ModelClasses.DataModelClass
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MarvelViewModel(repository: Repository) : ViewModel() {
    private val repository:Repository

    fun getVolumesResponseLiveData(): MutableLiveData<DataModelClass?> {
        return repository.getData()
    }

    init {
        this.repository = repository
    }
}