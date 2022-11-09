package com.example.cityapp.ui.theme

import android.annotation.SuppressLint
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cityapp.R
import com.example.cityapp.utils.CityNavigationType

enum class CityScreen(val title: Int) {
    Category(title = R.string.app_name),
    List(title = R.string.list),
    Detail(title = R.string.detail)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityApp(
    windowSize:WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController()

) {
    val viewModel = CityViewModel()
    val uiState by viewModel.uiState.collectAsState()

    val backStackEntry by navController.currentBackStackEntryAsState()

    val navigationType: CityNavigationType = when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            CityNavigationType.NoNavbar
        }
        WindowWidthSizeClass.Medium -> {
            CityNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            CityNavigationType.PERMANENT_NAVIGATION_DRAWER
        }

        else -> {
            CityNavigationType.NoNavbar
        }
    }


    val context = LocalContext.current

Scaffold(
    topBar = {
        CityAppTopBar(
            category = uiState.selectedCategory,
            currentScreen = CityScreen.valueOf(backStackEntry?.destination?.route ?: CityScreen.Category.name),
            canNavigateBack = navController.previousBackStackEntry != null,
            navigateUp = { navController.navigateUp() },
            sharedpage = {
                SharePage(
                    context = context,
                    name = uiState.SelectedPart.name,
                    description = uiState.SelectedPart.description
                )
            }
//            isDetailScreen = uiState.selectedCategory == CityScreen.Detail.name
        )
    }
) {innerPadding ->

    NavHost(
        navController = navController,
        startDestination = CityScreen.Category.name,
        modifier = modifier.padding(innerPadding)
    ) {
        composable(route = CityScreen.Category.name) {
            CategoryScreen(
                navigationType = navigationType,
                uiState = uiState,
                onClickNavigate = {
                    navController.navigate(CityScreen.List.name)
                },
                onChangeState = {
                    viewModel.updateCategory(it)
                }
            )
        }

        composable(route = CityScreen.List.name) {
            ListScreen(category = uiState.selectedCategory,
                onChangeSelection = {
                    viewModel.updateParticular(it)
                },

                onClick = {
                navController.navigate(CityScreen.Detail.name)
            })

        }
        composable(route = CityScreen.Detail.name) {
            DetailScreen(listItemShow = uiState.SelectedPart)
        }
    }
}

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityAppTopBar(
    category: String,
    currentScreen: CityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    sharedpage: () -> Unit,
    modifier: Modifier = Modifier
) {
//    Log.d("TopApp",isDetailScreen.toString())
    TopAppBar(
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Navigate back")

                }
            }

        },

        actions = {
                  if(currentScreen.name == CityScreen.Detail.name) {
                      IconButton(onClick = { sharedpage() }) {
                          Icon(imageVector = Icons.Filled.Share, contentDescription = "Shared Button")
                      }
                  }
        },
        title = { Text(text = stringResource(id = currentScreen.title, category)) },
    )
}

fun SharePage(
    context:Context,
    name:String,
    description: String
) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, name)
        putExtra(Intent.EXTRA_TEXT, description)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.app_name)
        )
    )
}