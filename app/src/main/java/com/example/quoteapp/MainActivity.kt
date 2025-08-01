package com.example.quoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quoteapp.presentation.screens.QuoteScreen
import com.example.quoteapp.presentation.state.quote.QuoteUiEvent
import com.example.quoteapp.presentation.state.quote.QuoteUiState
import com.example.quoteapp.presentation.viewmodel.QuoteViewModel
import com.example.quoteapp.ui.theme.QuoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteAppTheme {
                setContent {
                    val viewModel: QuoteViewModel = hiltViewModel()
                    val state by viewModel.state.collectAsState()

                    QuoteScreen(
                        state = state,
                        onEvent = { viewModel.onEvent(QuoteUiEvent.generateQuote) }
                    )
                }
            }
        }
    }
}
