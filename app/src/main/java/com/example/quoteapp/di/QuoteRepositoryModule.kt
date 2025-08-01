package com.example.quoteapp.di

import com.example.quoteapp.data.repositoryImp.QuoteRepositoryImp
import com.example.quoteapp.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuoteRepositoryModule {
    @Provides
    @Singleton
    fun provideQuoteRepository(): QuoteRepository {
        return QuoteRepositoryImp()
    }

}