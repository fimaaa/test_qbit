package com.example.qbittest.fragment.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.qbittest.R
import com.example.qbittest.adapter.BannerAdapter
import com.example.qbittest.adapter.ProductAdapter
import com.example.qbittest.customview.ZoomOutPageTransformer
import com.example.qbittest.fragment.home.HomeInterface
import com.example.qbittest.fragment.home.presenter.HomePresenter
import com.example.qbittest.helper.Util
import com.example.qbittest.model.data.BannerImage
import com.example.qbittest.model.data.Product
import kotlinx.android.synthetic.main.layout_home_fragment.*
import kotlinx.android.synthetic.main.toolbar_manualtop.*


class HomeFragment: Fragment(), HomeInterface.View {
    companion object{
        fun startFragment(title:String): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString("childFragment", title)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var mPresenter:HomeInterface.Presenter
    override fun initPresenter(): HomeInterface.Presenter {
       return HomePresenter(context!!,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.layout_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter = initPresenter()
        mPresenter.getDataBanner()
        mPresenter.getDataProduct()

        iv_open_toolbar.setOnClickListener {
            Util.imageViewAnimatedChange(context!!,iv_open_toolbar,resources.getDrawable(R.drawable.ic_close))
        }
    }

    override fun setBanner(listBanner: MutableList<BannerImage?>?) {
        vp_bannerimage.adapter = BannerAdapter(context!!,listBanner)
        vp_bannerimage.setPageTransformer(true, ZoomOutPageTransformer())    }

    override fun setProduct(listProduct: MutableList<Product?>?) {
        rcv_product.adapter = ProductAdapter(context!!,mPresenter,listProduct)
    }

    override fun setItemChart(chartSum: Int,productName:String) {
        tv_totalchart_toolbar.text = chartSum.toString()
        if(chartSum >0){
            tv_totalchart_toolbar.visibility = View.VISIBLE
        }
        Toast.makeText(context!!,"$productName is Added",Toast.LENGTH_SHORT).show()
    }

}