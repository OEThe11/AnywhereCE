package com.ocode.anywherece.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ocode.anywherece.components.AnyAppBar
import com.ocode.anywherece.model.AnywhereListEntity
import com.ocode.anywherece.widgets.AnyCard
import com.ocode.anywherece.widgets.SearchBar

@Composable
fun MainScreen(anyViewModel: AnyViewModel = hiltViewModel()){
    val allItems by anyViewModel.anyInfoResults.collectAsState()

   Scaffold(backgroundColor = MaterialTheme.colors.primaryVariant,
       topBar = {
        SearchBar(){
            anyViewModel.searchAnywhereList(it)
        }
       }, bottomBar = {
        AnyAppBar(elevation = 5.dp)
   }
   ) {
       Surface(modifier = Modifier
           .fillMaxSize()
           .padding(bottom = 55.dp),
           color = MaterialTheme.colors.primary
       ) {
           AnyList(list = allItems)
       }
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


