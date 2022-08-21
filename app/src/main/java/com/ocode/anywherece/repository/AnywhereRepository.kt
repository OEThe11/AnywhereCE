package com.ocode.anywherece.repository

import com.ocode.anywherece.data.AnywhereDao
import com.ocode.anywherece.data.DataOrException
import com.ocode.anywherece.mapper.AnywhereMapper
import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.network.AnywhereAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class AnywhereRepository @Inject constructor(
    private val api: AnywhereAPI,
    private val anywhereDao: AnywhereDao
){
//  private val dataOrException = DataOrException<List<AnywhereListEntity>, Boolean, Exception>()
//
//    suspend fun getAllInfos(): DataOrException<List<AnywhereListEntity>, Boolean, Exception>{
//        try {
//            dataOrException.loading = true
//            dataOrException.data = api.getAnyInfo()
//        }
//    }

        val feeds: Flow<List<AnywhereListEntity>>
            get() = anywhereDao.getInfo()


    suspend fun anywhereInfo(): List<AnywhereListEntity>? {
        val request = api.getAnyInfo()
        if (request.isSuccessful){
            val anyItems = request.body()!!.map {
                AnywhereMapper.buildFrom(it)
            }
            anywhereDao.insertInfo(*anyItems.toTypedArray())
            return anyItems
        }
        return null
    }
}