package com.example.assignment2.ui.theme

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AssignmentViewModel  : ViewModel() {

    private val _uiState = MutableStateFlow(AssignmentUiState(title = "hi"))
    val uiState : StateFlow<AssignmentUiState> = _uiState.asStateFlow()


}

data class AssignmentUiState(
    val title : String,

)