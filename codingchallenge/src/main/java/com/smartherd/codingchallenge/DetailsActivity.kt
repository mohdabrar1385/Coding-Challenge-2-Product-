package com.smartherd.codingchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.codingchallenge.databinding.ActivityDetailsBinding
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_details)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            val title = bundle!!.getString("title")
            txvTitle.text = title

            val description = bundle!!.getString("description")
            txvDescription.text = description

            val price = bundle!!.getString("price")
            txvPrice.text = price

            val rating = bundle!!.getString("rating")
            txvRating.text = rating
        }
    }
}