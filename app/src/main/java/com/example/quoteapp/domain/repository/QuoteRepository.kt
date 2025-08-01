package com.example.quoteapp.domain.repository

import com.example.quoteapp.domain.model.Quote
import javax.inject.Singleton

@Singleton
interface QuoteRepository {
    suspend fun getRandomNote(): Quote
}