package com.example.quoteapp.presentation.state.quote

import com.example.quoteapp.domain.model.Quote

data class QuoteUiState(
    val quote: Quote = Quote(
        0, "Tap the button to get inspired!",
        author = "UnKnown"
    ),
    val isLoading: Boolean = false,
    val error: String? = null
)
