package com.example.hofftest2.domain.interactor

import com.example.hofftest2.domain.common.SchedulersProvider
import com.example.hofftest2.domain.repository.DetailRepository
import com.example.hofftest2.domain.repository.OrderRepository
import javax.inject.Inject

class OrdersInteractor @Inject constructor(
    private val orderRepository: OrderRepository,
    private val detailRepository: DetailRepository,
    private val schedulers: SchedulersProvider
) {

    fun getList() = orderRepository.getOrders().observeOn(schedulers.ui)
    fun getDetail() = detailRepository.getDetail().observeOn(schedulers.ui)
}