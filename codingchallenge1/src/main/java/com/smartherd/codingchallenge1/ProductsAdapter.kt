package com.smartherd.codingchallenge1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    companion object {
        val TAG: String = ProductsAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product = products[position]
        holder.setData(product, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currentProduct: Product? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                currentProduct?.let { context.showToast(currentProduct!!.title + " Clicked !")
                }

                val temp_string =" This is the details of "+currentProduct!!.title +"...And its a nice Product"

                val intent = Intent(itemView.context, InformationActivity::class.java)
                    intent.putExtra("Details",temp_string )
                    itemView?.context?.startActivity(intent)


            }
        }

        fun setData(product: Product?, pos: Int) {
            product?.let {  itemView.txvTitle.text = product!!.title
            }
            this.currentProduct = product
            this.currentPosition = pos
        }
    }

}