package com.ocode.anywherece.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ocode.anywherece.model.AnywhereListEntity


@Database(entities = [AnywhereListEntity::class], version = 1, exportSchema = false)
abstract class AnywhereDatabase: RoomDatabase() {
    abstract fun  anywhereDao(): AnywhereDao
}