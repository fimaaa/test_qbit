package com.example.qbittest.fragment.home.presenter

import android.content.Context
import com.example.qbittest.R
import com.example.qbittest.fragment.home.HomeInterface
import com.example.qbittest.helper.Util
import com.example.qbittest.model.data.BannerImage
import com.example.qbittest.model.data.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomePresenter(private val mContext:Context, private val mView:HomeInterface.View) : HomeInterface.Presenter {
    private var item = 0

    override fun getDataBanner() {
        val json = Util.inputStreamToString(mContext, R.raw.banner_image)
        val listBannerImage =
            Gson().fromJson<MutableList<BannerImage?>?>(
                json,
                object : TypeToken<MutableList<BannerImage?>?>() {}.type
            )
        mView.setBanner(listBannerImage)
    }

    override fun getDataProduct() {
        val json = Util.inputStreamToString(mContext, R.raw.product_item)
        val listBannerImage =
            Gson().fromJson<MutableList<Product?>?>(
                json,
                object : TypeToken<MutableList<Product?>?>() {}.type
            )
        mView.setProduct(listBannerImage)
    }

    override fun addItemChart(productName:String) {
        item += 1
        mView.setItemChart(item,productName)
    }
}