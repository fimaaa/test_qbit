package com.example.qbittest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qbittest.R
import com.example.qbittest.adapter.BannerAdapter
import com.example.qbittest.adapter.ProductAdapter
import com.smarteist.autoimageslider.IndicatorAnimations
import com.smarteist.autoimageslider.SliderAnimations
import kotlinx.android.synthetic.main.layout_home_fragment.*

class HomeFragment: Fragment() {
    companion object{
        fun startFragment(title:String):HomeFragment{
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putString("childFragment", title)
            fragment.arguments = bundle
            return fragment
        }
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

        imageSlider.sliderAdapter = BannerAdapter(context!!)
        imageSlider.setSliderTransformAnimation(SliderAnimations.VERTICALSHUTTRANSFORMATION)
        imageSlider.setIndicatorAnimation(IndicatorAnimations.WORM)
        imageSlider.setIndicatorVisibility(false)

        rcv_product.adapter = ProductAdapter(context!!)
    }
}