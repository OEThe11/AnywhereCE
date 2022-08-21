package com.ocode.anywherece.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ocode.anywherece.repository.AnywhereRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnyViewModel @Inject constructor(
    private val repository: AnywhereRepository
): ViewModel() {
   val anyInfoResults = repository.feeds


    init {
        getAnyList()
    }

    private fun getAnyList(){
        viewModelScope.launch {
            try {
                repository.anywhereInfo()
            }catch (e: Exception){
                Log.e("VM",e.message, e.cause)
            }
        }
    }

}