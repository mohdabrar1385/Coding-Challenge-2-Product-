package com.smartherd.codingchallenge2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso


class ProductDetailsFragment : Fragment() {

    private val args by navArgs<com.smartherd.codingchallenge2.ProductDetailsFragmentArgs>()
    lateinit var ViewModel: ProductViewModel
    private lateinit var productAdapter: ProductAdapter


    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product_details, container, false)

        Picasso.get().load(args.product.image).into(view.findViewById<ImageView>(R.id.productImageView))
        view.findViewById<TextView>(R.id.tvTitle).text = args.product.title
        view.findViewById<TextView>(R.id.tvCategory).text = args.product.category
        view.findViewById<TextView>(R.id.tvPrice).text = args.product.price.toString()

        view.findViewById<Button>(R.id.btnDescription).setOnClickListener{
            view.findViewById<TextView>(R.id.tvDescription).text = args.product.description
        }
        view.findViewById<Button>(R.id.btnCategory).setOnClickListener{
            view.findViewById<TextView>(R.id.tvDescription).text = args.product.category
        }
        view.findViewById<Button>(R.id.btnRating).setOnClickListener{
            view.findViewById<TextView>(R.id.tvDescription).text = "${args.product.rating.rate.toString()} stars \n" +
                    " Rated by ${args.product.rating.count.toString()}"
        }

        var counterQuantity = 0
        var updatedPrice = args.product.price
            view.findViewById<Button>(R.id.addQuantity).setOnClickListener{
            counterQuantity++
            view.findViewById<TextView>(R.id.quantity).text = counterQuantity.toString()
                updatedPrice = args.product.price*counterQuantity
            view.findViewById<TextView>(R.id.tvPrice).text = updatedPrice.toString()
        }

        view.findViewById<Button>(R.id.subQuantity).setOnClickListener{
            if(counterQuantity>0) {
                counterQuantity--
                view.findViewById<TextView>(R.id.quantity).text = counterQuantity.toString()
                updatedPrice = args.product.price*counterQuantity
                view.findViewById<TextView>(R.id.tvPrice).text = updatedPrice.toString()
            }
        }

        view.findViewById<Button>(R.id.addToCart).setOnClickListener {

            val cart = args.product
            val productRepository = ProductRepository(ProductDatabase(requireContext()))
            val factory = ProductViewModelFactory(productRepository)
            ViewModel = ViewModelProvider(this, factory).get(ProductViewModel::class.java)
            val product1 = Product1(args.product.category, args.product.description, args.product.id,
                args.product.image, updatedPrice, args.product.title, counterQuantity)
            ViewModel.insert(product1)
            Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
            //val action = ProductDetailsFragmentDirections.actionProductDetailsFragmentToCartFragment()
            //(Navigation.findNavController(view).navigate(R.id.action_productDetailsFragment_to_cartFragment))
        }

        return view
    }
}