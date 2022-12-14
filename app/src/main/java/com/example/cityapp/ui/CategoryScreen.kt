package com.example.cityapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cityapp.Data.DataSource
import com.example.cityapp.utils.CityNavigationType


@Composable
fun CategoryScreen(
    navigationType: CityNavigationType,
    uiState: CityUiState,
    onClickNavigate: () -> Unit,
    onChangeState: (String) -> Unit
) {
    ShowCategory(
        CategoryList = DataSource.Category,
        onClickNavigate = onClickNavigate,
        onChangeState = onChangeState
    )

}



@Composable
fun ShowCategory(
    CategoryList: List<String>,
    modifier:Modifier = Modifier,
    onClickNavigate: () -> Unit,
    onChangeState: (String) -> Unit
) {
        LazyColumn {
            items(CategoryList) { category ->
                CategoryCard(Category = category, onClickNavigate = onClickNavigate, onChangeState = onChangeState)
            }
        }

}


@Composable
fun CategoryCard(
    Category:String,
    modifier: Modifier = Modifier,
    onClickNavigate: () -> Unit,
    onChangeState: (String) -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clickable {
                onChangeState(Category)
                onClickNavigate()
            }
    ) {
        Text(text = Category, modifier = Modifier.padding(32.dp))
    }

}