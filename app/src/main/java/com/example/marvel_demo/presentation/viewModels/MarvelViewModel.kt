package com.example.marvel_demo.presentation.viewModels

import com.example.marvel_demo.data.ModelClasses.DataModelClass
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marvel_demo.data.repository.Repository


class MarvelViewModel(repository: Repository) : ViewModel() {
    private val repository: Repository

    fun getVolumesResponseLiveData(): MutableLiveData<DataModelClass?> {
        return repository.getData()
    }

    init {
        this.repository = repository
    }
}