package com.example.cityapp.ui

import androidx.lifecycle.ViewModel
import com.example.cityapp.Data.Detail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(CityUiState("",Detail(-1,"","")))
    val uiState: StateFlow<CityUiState> = _uiState


    fun updateCategory(selectedCategory: String) {
        _uiState.update { current ->
            current.copy(
                selectedCategory = selectedCategory
            )
        }
    }

    fun updateParticular(selectedComponent: Detail) {
        _uiState.update { current ->
            current.copy(
                SelectedPart = selectedComponent
            )
        }
    }

}