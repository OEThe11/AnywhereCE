package com.ocode.anywherece.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ocode.anywherece.model.AnywhereListEntity

@Composable
fun MainScreen(anyViewModel: AnyViewModel = hiltViewModel()){
    val allItems by anyViewModel.anyInfoResults.collectAsState(initial = emptyList())

    Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
    ) {
        AnyList(list = allItems)
    }
}

@Composable
fun AnyList(list: List<AnywhereListEntity>) {
    LazyColumn{
        items(list){item ->
            AnyCard(anyItems = item)
        }
    }
}

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
