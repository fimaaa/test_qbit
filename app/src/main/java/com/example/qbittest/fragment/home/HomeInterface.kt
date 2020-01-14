package com.example.qbittest.fragment.home

import com.example.qbittest.base.BasePresenter
import com.example.qbittest.base.BaseView
import com.example.qbittest.model.data.BannerImage
import com.example.qbittest.model.data.Product

interface HomeInterface {
    interface View: BaseView<Presenter> {
        fun setBanner(listBanner:MutableList<BannerImage?>?)
        fun setProduct(listProduct:MutableList<Product?>?)

        fun setItemChart(chartSum:Int,productName:String)

    }
    interface Presenter: BasePresenter<View> {

        fun getDataBanner()
        fun getDataProduct()

        fun addItemChart(productName:String)
    }
}