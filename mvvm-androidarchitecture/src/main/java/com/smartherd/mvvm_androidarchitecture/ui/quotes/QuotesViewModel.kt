package com.smartherd.mvvm_androidarchitecture.ui.quotes

import androidx.lifecycle.ViewModel
import com.smartherd.mvvm_androidarchitecture.data.Quote
import com.smartherd.mvvm_androidarchitecture.data.QuoteRepository


class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}