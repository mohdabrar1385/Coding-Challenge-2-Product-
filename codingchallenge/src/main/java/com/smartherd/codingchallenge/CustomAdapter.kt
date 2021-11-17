package com.smartherd.codingchallenge
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.util.*

class CustomAdapter(
    private var context: Context,
    private var productTitle: ArrayList<String>,
    private var productDescription: ArrayList<String>,
    private var productPrice: ArrayList<String>,
    private var productRating: ArrayList<String>
) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rowlayout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // set the data in items
        holder.productTitle.text = productTitle[position]
        holder.productDescription.text = productDescription[position]
        // implement setOnClickListener event on item view.
            holder.itemView.setOnClickListener { // display a toast with person name on item click
                val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
                intent.putExtra("title", productTitle[position])
                intent.putExtra("description", productDescription[position])
                intent.putExtra("price", productPrice[position])
                intent.putExtra("rating", productRating[position])
                holder.itemView?.context?.startActivity(intent)
            }
    }

    override fun getItemCount(): Int {
        return productTitle.size
    }

    inner class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        var productTitle: TextView = itemView.findViewById<View>(R.id.tvTitle) as TextView
        var productDescription: TextView =
            itemView.findViewById<View>(R.id.tvDescription) as TextView

        }
    }
