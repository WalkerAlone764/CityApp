package com.example.cityapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cityapp.Data.DataSource
import com.example.cityapp.Data.Detail

@Composable
fun ListScreen(
    category: String,
    onClick:() -> Unit,
    onChangeSelection: (Detail) -> Unit,
    modifier: Modifier = Modifier
) {
    val dataset:List<Detail> = when(category) {
        "Park" -> {
            DataSource.ParkList
        }
        "Restaurant" -> {
            DataSource.RestaurantList
        }
        else -> {
            DataSource.ParkList
        }
    }


    LazyColumn {
        items(dataset) {data ->
            ShowList(data = data, onClick = onClick, onChangeSelection = onChangeSelection)
        }
    }

}


@Composable
fun ShowList(
    data: Detail,
    onChangeSelection: (Detail) -> Unit,
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 12.dp)
            .clickable {
                onChangeSelection(data)
                onClick()
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                painter = painterResource(id = data.imageId),
                contentDescription = null,
                modifier = modifier
                    .size(128.dp)
                    .clip(MaterialTheme.shapes.small)
            )
            Text(text = data.name, modifier = modifier
//                .align(Alignment.CenterVertically)
                .padding(start = 12.dp),
                textAlign = TextAlign.Right
            )


        }

    }

}

@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(category = "Park", onClick = {}, onChangeSelection = {})
}


