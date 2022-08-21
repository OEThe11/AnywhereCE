package com.ocode.anywherece.mapper

import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.model.GetAnyResponse


object AnywhereMapper {
    fun buildFrom(response: GetAnyResponse): AnywhereListEntity{
        return AnywhereListEntity(
            name = response.RelatedTopics[0].parts[0],
            description = response.RelatedTopics[0].parts[1]
        )
    }
}