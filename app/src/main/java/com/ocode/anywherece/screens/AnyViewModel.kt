package com.ocode.anywherece.screens

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.repository.AnywhereRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnyViewModel @Inject constructor(
    private val repository: AnywhereRepository
): ViewModel() {

    private var _anyInfoResults = MutableStateFlow<List<AnywhereListEntity>>(emptyList())
    val anyInfoResults = _anyInfoResults.asStateFlow()



    private var cachedSearch = listOf<AnywhereListEntity>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

init {
    getAnyList()
}

    fun searchAnywhereList(query: String){
        val listToSearch = if(isSearchStarting){ _anyInfoResults.value }
                            else { cachedSearch }
        viewModelScope.launch(Dispatchers.Default){
            if (query.isEmpty()){
                _anyInfoResults.value = cachedSearch
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.name.contains(query, ignoreCase = true)
            }
            if (isSearchStarting){
                cachedSearch = _anyInfoResults.value
                isSearchStarting = false
            }
            _anyInfoResults.value = results
            isSearching.value = true
        }
    }


    private fun getAnyList(){
        viewModelScope.launch {
            try {
            _anyInfoResults.value = repository.anywhereInfo()!!
            }catch (e: Exception){
                Log.e("VM",e.message, e.cause)
            }
        }
    }

}