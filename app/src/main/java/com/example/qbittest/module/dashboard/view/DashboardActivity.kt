package com.example.qbittest.module.dashboard.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.qbittest.R
import com.example.qbittest.fragment.EmptyFragment
import com.example.qbittest.fragment.home.view.HomeFragment
import com.example.qbittest.module.dashboard.DashboardInterface
import com.example.qbittest.module.dashboard.presenter.DashboardPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.layout_dashboard_activity.*

class DashboardActivity:AppCompatActivity(), DashboardInterface.View,
    BottomNavigationView.OnNavigationItemSelectedListener {

    private val mPresenter = initPresenter()

    private val homeFragment = HomeFragment.startFragment("")
    private val favFragment = EmptyFragment.startFragment("Favorite")
    private val profileFragment = EmptyFragment.startFragment("Profile")
    private val fm: FragmentManager = supportFragmentManager
    private var active:Fragment = homeFragment


    override fun initPresenter(): DashboardInterface.Presenter {
        return DashboardPresenter(this,this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_dashboard_activity)

        bottomnavigation_dashboard.setOnNavigationItemSelectedListener(this)
        initView()
    }

    private fun initView(){
        fm.beginTransaction().add(R.id.content, favFragment, "2").hide(favFragment)
            .commit()
        fm.beginTransaction().add(R.id.content, profileFragment, "3").hide(profileFragment)
            .commit()
        fm.beginTransaction().add(R.id.content, homeFragment, "1").commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_home ->{
                fm.beginTransaction().hide(active).show(homeFragment).commit()
                active = homeFragment
                return true
            }
            R.id.navigation_favorite ->{
                fm.beginTransaction().hide(active).show(favFragment).commit()
                active = favFragment
                return true
            }
            R.id.navigation_profile ->{
                fm.beginTransaction().hide(active).show(profileFragment).commit()
                active = profileFragment
                return true
            }
        }
        return false
    }
}