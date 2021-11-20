package com.smartherd.mvvm_androidarchitecture.utilities

import com.smartherd.mvvm_androidarchitecture.data.FakeDatabase
import com.smartherd.mvvm_androidarchitecture.data.QuoteRepository
import com.smartherd.mvvm_androidarchitecture.ui.quotes.QuotesViewModelFactory


object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}