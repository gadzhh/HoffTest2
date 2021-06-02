package com.example.hofftest2.presentation.detail.mvp

import com.example.hofftest2.domain.interactor.OrdersInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailPresenter @Inject constructor(
    private val interactor: OrdersInteractor
) {

    private lateinit var detailView: DetailView
    private lateinit var orderDisposables: Disposable

    fun attachView(view: DetailView) {
        this.detailView = view
        load()
    }

    private fun load() {
        orderDisposables = interactor.getDetail()
            .doOnSubscribe {
                detailView.showProgress()
            }.doAfterTerminate {
                detailView.hideProgress()
            }.subscribeBy(
                onSuccess = { model ->
                    detailView.showData(detail = model)
                },
                onError = { error ->
                    detailView.showError(error.message ?: "Что-то пошло не так, попробуйте позже")
                }
            )
    }
}