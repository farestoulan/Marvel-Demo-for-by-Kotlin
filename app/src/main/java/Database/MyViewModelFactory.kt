package Database


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(repository:Repository) : ViewModelProvider.Factory {
    private val repository: Repository

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MarvelViewModel::class.java)) {
            MarvelViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

    init {
        this.repository = repository
    }


}