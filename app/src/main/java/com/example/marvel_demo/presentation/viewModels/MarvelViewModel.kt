package com.example.marvel_demo.presentation.viewModels

import androidx.lifecycle.LiveData
import com.example.marvel_demo.data.models.DataModelClass
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_demo.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    suspend fun getData(): LiveData<DataModelClass?>{
        return repository.getData()
    }
}