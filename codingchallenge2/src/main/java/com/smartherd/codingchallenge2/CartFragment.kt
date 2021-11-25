package com.smartherd.codingchallenge2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.codingchallenge2.databinding.CartBinding

class CartFragment : Fragment() {

    val args: com.smartherd.codingchallenge2.CartFragmentArgs by navArgs()
    private lateinit var cartBinding: CartBinding
    lateinit var ViewModel: ProductViewModel
    lateinit var list: List<Product1>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        val productRepository = ProductRepository(ProductDatabase(requireContext()))
        val factory = ProductViewModelFactory(productRepository)

        // Initialised View Model
        ViewModel = ViewModelProvider(this, factory).get(ProductViewModel::class.java)
        val cartAdapter = CartAdapter(listOf(), ViewModel)
        view.findViewById<RecyclerView>(R.id.rvProducts).layoutManager = LinearLayoutManager(requireContext())
        view.findViewById<RecyclerView>(R.id.rvProducts).adapter = cartAdapter


        // To display all items in recycler view
        ViewModel.readAllData().observe(viewLifecycleOwner, Observer {
            cartAdapter.list = it
            cartAdapter.notifyDataSetChanged()
        })

        //val product1 = Product1(args.cart.category, args.cart.description, args.cart.id,
           // args.cart.image, args.cart.price, args.cart.title)
        // ViewModel.insert(product1)

        return view
    }

}