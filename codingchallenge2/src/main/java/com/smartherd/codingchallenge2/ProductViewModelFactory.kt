package com.smartherd.codingchallenge2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ProductViewModelFactory(private val repository: ProductRepository):ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}
