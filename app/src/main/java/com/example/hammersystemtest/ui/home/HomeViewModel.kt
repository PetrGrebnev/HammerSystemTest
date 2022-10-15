package com.example.hammersystemtest.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hammersystemtest.data.database.Food
import com.example.hammersystemtest.data.responsenetwork.DataResult
import com.example.hammersystemtest.model.Repository
import com.example.hammersystemtest.utils.CheckInternet
import com.example.hammersystemtest.utils.ResultState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository,
    context: Context
) : ViewModel() {

    private val _dataNetwork = MutableLiveData<ResultState<List<Food>>>()
    val dataNetwork: LiveData<ResultState<List<Food>>> = _dataNetwork

    init {
        if (CheckInternet.isInternetAvailable(context)) {
            getAllProduct()
        } else {
            getAllProductDatabase()
        }
    }

    private fun getAllProduct() {
        val list = mutableListOf<Food>()
        _dataNetwork.value = ResultState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getAllProduct()
            if (response.isSuccessful) {
                val dataProduct = response.body()
                if (dataProduct != null) {
                    dataProduct.Result.forEach { item ->
                        val food = repository.mapper(item)
                        repository.cleanDatabase()
                        repository.setSaveData(food)
                        list.add(food)
                    }
                }
                _dataNetwork.postValue(ResultState.Success(list))
            } else {
                _dataNetwork.postValue(ResultState.Error(RuntimeException("Response body null")))
            }
        }
    }

    private fun getAllProductDatabase() {
        _dataNetwork.value = ResultState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getAllProductDatabase()
            if (data != null){
                _dataNetwork.postValue(ResultState.Success(data))
            } else {
                _dataNetwork.postValue(ResultState.Error(RuntimeException("Response body null")))
            }
        }
    }
}