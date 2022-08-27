package com.ocode.anywherece.widgets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ocode.anywherece.model.AnywhereListEntity

@Composable
fun AnyCard(anyItems: AnywhereListEntity) {
    Card  (modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .padding(16.dp),
        shape = RoundedCornerShape(size = 20.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 11.dp
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(text = anyItems.name)
        }
    }
}

@Composable
fun SearchBar() {

}