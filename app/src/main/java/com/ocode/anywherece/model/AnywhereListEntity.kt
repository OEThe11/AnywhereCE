package com.ocode.anywherece.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "any_name")
data class AnywhereListEntity(
    @PrimaryKey
    val name: String,
    val description: String
)
