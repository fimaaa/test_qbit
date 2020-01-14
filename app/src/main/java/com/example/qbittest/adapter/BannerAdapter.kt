package com.example.qbittest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.qbittest.R
import com.example.qbittest.helper.Util
import com.example.qbittest.model.data.BannerImage
import kotlinx.android.synthetic.main.item_banner_image.view.*


class BannerAdapter(private val mContext:Context, private val listBannerImage: MutableList<BannerImage?>?): PagerAdapter() {


    private val mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val requestOptions = Util.getRequestOption()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun getCount(): Int {
        return listBannerImage?.size?:0
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView: View =
            mLayoutInflater.inflate(R.layout.item_banner_image, container, false)
        Glide.with(mContext)
            .applyDefaultRequestOptions(requestOptions)
            .load(listBannerImage?.get(position)?.image)
            .into(itemView.iv_banner_item)
        container.addView(itemView)

        return itemView
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.destroyItem(container, position, `object`)
        container.removeView(`object` as LinearLayout)
    }
}