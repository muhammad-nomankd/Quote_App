package com.example.quoteapp.data.repositoryImp

import com.example.quoteapp.data.source.QuoteSource
import com.example.quoteapp.domain.model.Quote
import com.example.quoteapp.domain.repository.QuoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteRepositoryImp ():
    QuoteRepository {

    override suspend fun getRandomNote(): Quote {
       return QuoteSource.quotes.random()
    }

}