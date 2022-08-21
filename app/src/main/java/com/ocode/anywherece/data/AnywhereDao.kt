package com.ocode.anywherece.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ocode.anywherece.model.AnywhereListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnywhereDao {
    @Query("SELECT * FROM any_name")
    fun getInfo(): Flow<List<AnywhereListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInfo(vararg info: AnywhereListEntity)
}