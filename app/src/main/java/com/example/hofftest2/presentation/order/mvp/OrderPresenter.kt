package com.example.hofftest2.presentation.order.mvp

import com.example.hofftest2.domain.interactor.OrdersInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class OrderPresenter @Inject constructor(
    private val interactor: OrdersInteractor
) {

    private lateinit var orderView: OrderView
    private lateinit var orderDisposables: Disposable

    fun attachView(view: OrderView) {
        this.orderView = view
        load()
    }

    private fun load() {
        orderDisposables = interactor.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                orderView.showProgress()
            }
            .doAfterTerminate {
                orderView.hideProgress()
            }.subscribeBy(
                onSuccess = { model ->
                    orderView.showOrders(orders = model)
                },
                onError = { error ->
                    orderView.showError(error.message ?: "Что-то пошло не так, попробуйте позже")
                }
            )
    }
}