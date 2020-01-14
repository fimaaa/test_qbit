package com.example.qbittest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.qbittest.R
import com.example.qbittest.fragment.home.HomeInterface
import com.example.qbittest.helper.Util
import com.example.qbittest.model.data.Product
import kotlinx.android.synthetic.main.item_product_recyclerview.view.*

class ProductAdapter(private val mContext:Context,private val listener:HomeInterface.Presenter, private val listProduct:MutableList<Product?>?) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val requestOptions = Util.getRequestOption()

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(R.layout.item_product_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = listProduct?.get(position)
        holder.itemView.tv_name_product.text = data?.nameProducts
        holder.itemView.btn_addchart_product.setOnClickListener {
            listener.addItemChart(data?.nameProducts?:"null")
        }
        Glide.with(mContext)
            .applyDefaultRequestOptions(requestOptions)
            .load(data?.imageProducts)
            .into(holder.itemView.iv_product)
    }

}