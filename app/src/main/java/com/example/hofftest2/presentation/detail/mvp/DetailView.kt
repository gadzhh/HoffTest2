package com.example.hofftest2.presentation.detail.mvp

import com.example.hofftest2.data.model.detailorder.DetailItems
import com.example.hofftest2.data.model.detailorder.OrderDetail

interface DetailView {
    fun showProgress()
    fun hideProgress()
    fun showData(detail: OrderDetail)
    fun showError(error: String)
}