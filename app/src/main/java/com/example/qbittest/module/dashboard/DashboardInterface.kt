package com.example.qbittest.module.dashboard

import com.example.qbittest.base.BasePresenter
import com.example.qbittest.base.BaseView

interface DashboardInterface {
    interface View: BaseView<Presenter>
    interface Presenter: BasePresenter<View>
}