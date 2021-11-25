package com.smartherd.codingchallenge2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.HttpException
import java.io.IOException

const val TAG = "MainActivity"

class ProductFragment : Fragment() {


    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)
        //BottomNavbar config

        view.findViewById<RecyclerView>(R.id.rvProducts).apply {

            productAdapter = ProductAdapter()
            adapter = productAdapter
            layoutManager = LinearLayoutManager(context)

        }
        lifecycleScope.launchWhenCreated {

            view.findViewById<ProgressBar>(R.id.progressBar).isVisible = true
            val response = try {
                RetrofitInstance.api.getProducts()
            } catch(e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection1")
                view.findViewById<ProgressBar>(R.id.progressBar).isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                view.findViewById<ProgressBar>(R.id.progressBar).isVisible = false
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null) {
                Toast.makeText(context, "Response successful", Toast.LENGTH_SHORT).show()
                productAdapter.products = response.body()!!
            } else {
                Toast.makeText(context, "Response not successful", Toast.LENGTH_SHORT).show()
            }
            view.findViewById<ProgressBar>(R.id.progressBar).isVisible = false
        }


        return view
    }
}