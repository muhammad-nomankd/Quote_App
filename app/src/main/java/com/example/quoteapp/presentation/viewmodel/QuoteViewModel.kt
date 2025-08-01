package com.example.quoteapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapp.domain.repository.QuoteRepository
import com.example.quoteapp.presentation.state.quote.QuoteUiEvent
import com.example.quoteapp.presentation.state.quote.QuoteUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val repository: QuoteRepository): ViewModel() {

    private val _state = MutableStateFlow(QuoteUiState())
    val state: StateFlow<QuoteUiState> = _state

    fun onEvent(event: QuoteUiEvent){
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when(event){
                is QuoteUiEvent.generateQuote -> {
                    val newQuote = repository.getRandomNote()
                    _state.update {
                        it.copy(quote = newQuote, isLoading = false)
                    }
                }
            }
        }

    }


}