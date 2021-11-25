package com.smartherd.codingchallenge2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    // In coroutines thread insert item in insert function.
    fun insert(item: Product1) = GlobalScope.launch {
        repository.insert(item)
    }

    // In coroutines thread delete item in delete function.
    fun delete(item: Product1) = GlobalScope.launch {
       repository.delete(item)
    }

    //Here we initialized allGroceryItems function with repository
    fun readAllData() = repository.readAllData()

}
