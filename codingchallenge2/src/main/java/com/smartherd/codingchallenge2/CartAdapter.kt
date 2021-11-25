package com.smartherd.codingchallenge2

import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.smartherd.codingchallenge2.databinding.CartBinding

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cart.view.*


class CartAdapter(var list: List<Product1>, val viewModel: ProductViewModel) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    // Inner class for viewHolder

    inner class CartViewHolder(binding: CartBinding) : RecyclerView.ViewHolder(binding.root)

    // In this function we will add our groceryadapter.xml to kotlin class
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
            CartBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // This function is used to return total number of size of list.
    override fun getItemCount(): Int {
        return list.size
    }

    // In onBindViewHolder we will bind our itemViews with adapter
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        var currentPosition = list[position]
        Picasso.get().load(currentPosition.image)
            .into(holder.itemView.findViewById<ImageView>(R.id.productImageView))
        holder.itemView.tvTitle.text = currentPosition.title
        holder.itemView.tvCategory.text = currentPosition.category
        holder.itemView.tvPrice.text = currentPosition.price.toString()
        holder.itemView.quantity.text = currentPosition.counter.toString()

        holder.itemView.findViewById<ImageView>(R.id.imageDelete).setOnClickListener {

            viewModel.delete(currentPosition)
        }
        var counterQuantity = currentPosition.counter
        var updatedPrice = currentPosition.price
        holder.itemView.findViewById<Button>(R.id.addQuantity).setOnClickListener {
            counterQuantity++
            holder.itemView.findViewById<TextView>(R.id.quantity).text = counterQuantity.toString()
            updatedPrice = currentPosition.price * counterQuantity
            holder.itemView.findViewById<TextView>(R.id.tvPrice).text = updatedPrice.toString()
        }

        holder.itemView.findViewById<Button>(R.id.subQuantity).setOnClickListener {
            if (counterQuantity > 0) {
                counterQuantity--
                holder.itemView.findViewById<TextView>(R.id.quantity).text =
                    counterQuantity.toString()
                updatedPrice = currentPosition.price * counterQuantity
                holder.itemView.findViewById<TextView>(R.id.tvPrice).text = updatedPrice.toString()
            }

            /*// To get total cost
        if (position == list.size - 1) {
            var totalCost = 0
            for (i in 0 until list.size) {
                totalCost += list[i].itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"
        }*/
        }
    }
}