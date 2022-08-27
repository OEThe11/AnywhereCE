package com.ocode.anywherece.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ocode.anywherece.R

@Composable
fun AnyAppBar(
    elevation: Dp = 0.dp
) {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = elevation) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.anywherelogo),
                contentDescription = "App Icon",
                contentScale = ContentScale.Fit
            )
        }
    }
}