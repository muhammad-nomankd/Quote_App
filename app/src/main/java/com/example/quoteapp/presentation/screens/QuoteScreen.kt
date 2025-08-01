package com.example.quoteapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Shuffle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteapp.presentation.components.QuoteCard
import com.example.quoteapp.presentation.state.quote.QuoteUiEvent
import com.example.quoteapp.presentation.state.quote.QuoteUiState
import com.example.quoteapp.ui.theme.indigo
import com.example.quoteapp.ui.theme.purple
import com.example.quoteapp.ui.theme.violet

@Composable
fun QuoteScreen(
    state: QuoteUiState, onEvent: (QuoteUiEvent) -> Unit
) {
    val verticalScroll = rememberScrollState()

    val contentColor =
        if (!isSystemInDarkTheme()) Color.White else Color.Black
    val containerColor =
        if (isSystemInDarkTheme()) Color.Black else Color.White
    val gradient = Brush.linearGradient(
        colors = listOf(
            violet, purple, indigo
        ), start = Offset.Zero, end = Offset.Infinite
    )
    Box(
        Modifier
            .background(gradient)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(verticalScroll),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .background(
                        containerColor.copy(alpha = 0.1f), RoundedCornerShape(16.dp)
                    )
                    .border(width = 1.dp, color = purple, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(48.dp)
                )
            }

            Spacer(Modifier.height(16.dp))
            Text(
                "Daily Inspiration",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Discover Wisdom that sparks your journeying",
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor
            )

            Spacer(Modifier.height(16.dp))

            QuoteCard(state.quote.text, state.quote.author)
            Spacer(modifier = Modifier.height(24.dp))
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onEvent(QuoteUiEvent.generateQuote) },
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                contentPadding = PaddingValues()
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    Color(0xFFB36AF5), Color(0xFF8A2BE2)
                                )
                            ),
                            shape = RoundedCornerShape(32.dp),
                        )
                        .border(width = 1.5.dp, color = purple,RoundedCornerShape(32.dp))
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Shuffle,
                            contentDescription = null,
                            tint = contentColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Get Random Quote",
                            color = contentColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }


        }
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Let these words guide your path forward",
            style = MaterialTheme.typography.labelMedium,
            color = contentColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
        )

    }


}