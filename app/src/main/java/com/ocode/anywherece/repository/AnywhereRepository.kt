package com.ocode.anywherece.repository

import com.ocode.anywherece.data.AnywhereDao
import com.ocode.anywherece.mapper.AnywhereMapper
import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.network.AnywhereAPI
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnywhereRepository @Inject constructor(
    private val api: AnywhereAPI,
    private val anywhereDao: AnywhereDao
){


//    suspend fun getAllInfos(): DataOrException<GetAnyResponse, Boolean, Exception>{
//        val response = try {
//          api.getAnyInfo()
//        }catch (e: Exception){
//            Log.d("REPO", "getAllInfos: $e")
//            return DataOrException(e = e)
//        }
//        Log.d("REPO INSIDE", "getAllInfos: $response")
//        return DataOrException(data = response)
//    }

    val feeds: Flow<List<AnywhereListEntity>>
        get() = anywhereDao.getInfo()


    suspend fun anywhereInfo(): List<AnywhereListEntity>? {
        val request = api.getAnyInfo()
        if (request.isSuccessful){
            val anyItems = request.body()!!.let{
                it.RelatedTopics.forEach { item ->
                    AnywhereMapper.buildFrom(item)
                }
            }
            anywhereDao.insertInfo(anyItems)
            return listOf(anyItems)
        }
        return null
    }
}