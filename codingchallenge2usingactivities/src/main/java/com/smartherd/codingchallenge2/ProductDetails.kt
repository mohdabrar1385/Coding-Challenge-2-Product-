package com.smartherd.codingchallenge2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.codingchallenge2.databinding.ProductDetailsBinding

class ProductDetails : AppCompatActivity() {

    private lateinit var binding: ProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailsBinding.inflate(layoutInflater)
        setContentView(R.layout.product_details)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val test = intent.getStringArrayListExtra("test")
            binding.textView.text =

            val description = bundle!!.getString("description")
            txvDescription.text = description

            val price = bundle!!.getString("price")
            txvPrice.text = price

            val rating = bundle!!.getString("rating")
            txvRating.text = rating
        }
    }
}