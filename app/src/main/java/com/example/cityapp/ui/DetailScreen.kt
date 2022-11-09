package com.example.cityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cityapp.Data.Detail


@Composable
fun DetailScreen(
    listItemShow: Detail,
    modifier: Modifier = Modifier
) {
    DetailPage(listItemShow = listItemShow)

}

@Composable
fun DetailPage(
    listItemShow: Detail,
    modifier: Modifier = Modifier
) {
    val scrollstate = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(scrollstate, enabled = true, orientation = Orientation.Vertical)
    ) {



        Image(
            painter = painterResource(id = listItemShow.imageId),
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
//                .padding(start = 2.dp, end = 2.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = listItemShow.name,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = listItemShow.description,
//            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)

        )




    }
}