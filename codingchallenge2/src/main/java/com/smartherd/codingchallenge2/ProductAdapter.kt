package com.smartherd.codingchallenge2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.codingchallenge2.databinding.ProductBinding
import com.squareup.picasso.Picasso
import androidx.navigation.Navigation
import com.smartherd.codingchallenge2.ProductFragmentDirections


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(val binding: ProductBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var products: List<Product>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.apply {
            val product = products[position]
            Picasso.get().load(product.image).into(productImageView)
            tvTitle.text = product.title
            tvPrice.text = product.price.toString()

            holder.itemView.setOnClickListener { // display a toast with person name on item click
                //val intent = Intent(holder.itemView.context, ProductDetailsFragment::class.java)

              val action = ProductFragmentDirections.actionProductFragmentToProductDetailsFragment(product)
                val navController = Navigation.findNavController(holder.itemView)
                navController!!.navigate(action)
            }
        }
    }
}