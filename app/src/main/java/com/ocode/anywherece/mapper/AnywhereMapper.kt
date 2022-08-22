package com.ocode.anywherece.mapper

import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.model.GetAnyResponse
import com.ocode.anywherece.model.RelatedTopic




object AnywhereMapper {
    fun buildFrom(response: RelatedTopic): AnywhereListEntity{
        return AnywhereListEntity(
            name = response.parts[0],
            description = response.parts[1]
        )
    }


}