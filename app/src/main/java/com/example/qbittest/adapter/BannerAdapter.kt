package com.example.qbittest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qbittest.R
import com.smarteist.autoimageslider.SliderViewAdapter


class BannerAdapter(private val mContext:Context): SliderViewAdapter<BannerAdapter.SliderAdapterVH>() {
    class SliderAdapterVH(itemView: View) :
        ViewHolder(itemView)

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(mContext)
            .inflate(R.layout.item_banner_image, null)
        return SliderAdapterVH(inflate)
    }

    override fun getCount(): Int {
        return 5
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {

    }
}