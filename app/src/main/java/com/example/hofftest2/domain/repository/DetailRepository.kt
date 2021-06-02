package com.example.hofftest2.domain.repository

import com.example.hofftest2.data.model.detailorder.OrderDetail
import io.reactivex.Single

interface DetailRepository {
    fun getDetail(): Single<OrderDetail>
}