package com.example.hofftest2.presentation.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hofftest2.App
import com.example.hofftest2.R
import com.example.hofftest2.data.model.detailorder.OrderDetail
import com.example.hofftest2.presentation.Screens
import com.example.hofftest2.presentation.detail.mvp.DetailPresenter
import com.example.hofftest2.presentation.detail.mvp.DetailView
import com.example.hofftest2.presentation.detail.ui.adapter.DetailProductItemsAdapter
import com.example.hofftest2.presentation.detail.ui.adapter.DetailServiceItemsAdapter
import com.example.hofftest2.presentation.order.ui.OrderFragment
import com.example.hofftest2.utils.format
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class DetailFragment : Fragment(), DetailView {

    private lateinit var detailProductsAdapter: DetailProductItemsAdapter
    private lateinit var detailServicesAdapter: DetailServiceItemsAdapter
    private lateinit var rvProducts: RecyclerView
    private lateinit var rvServices: RecyclerView
    private lateinit var progress: FrameLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    @Inject
    lateinit var presenter: DetailPresenter

    @Inject
    lateinit var router: Router

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        initPresenter()
    }

    private fun initViews(view: View) {

        detailProductsAdapter = DetailProductItemsAdapter()
        detailServicesAdapter = DetailServiceItemsAdapter()
        progress = view.findViewById(R.id.detail_progress)

        rvProducts = view.findViewById(R.id.rv_products)
        rvServices = view.findViewById(R.id.rv_services)

        rvProducts.adapter = detailProductsAdapter
        rvServices.adapter = detailServicesAdapter

        toolbar = view.findViewById(R.id.toolbar_detail)
        toolbar.setNavigationOnClickListener {

            router.navigateTo(Screens.orderScreen())
        }
    }

    private fun initPresenter() {
        if (detailProductsAdapter.itemCount == 0)
            presenter.attachView(this)

        if (detailServicesAdapter.itemCount == 0)
            presenter.attachView(this)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showData(detail: OrderDetail) {
        detailProductsAdapter.setDetailData(detail.detailItems)
        detailServicesAdapter.setServicesData(detail.services)

        val tvStatus: TextView = view!!.findViewById(R.id.tv_status_detail)
        val tvBuildDate: TextView = view!!.findViewById(R.id.tv_build_date)
        val tvDeliveryAdress: TextView = view!!.findViewById(R.id.tv_delivery_adress)
        val tvPayment: TextView = view!!.findViewById(R.id.tv_payment)
        val tvBonusCard: TextView = view!!.findViewById(R.id.tv_bonus_card)
        val tvPayedBonusesNumber: TextView = view!!.findViewById(R.id.tv_payed_bonuses_number)
        val tvDiscountNumber: TextView = view!!.findViewById(R.id.tv_discount_number)
        val tvTotalNumber: TextView = view!!.findViewById(R.id.tv_total_number)
//        val tvRvProductQuantity: TextView = view!!.findViewById(R.id.tv_rv_products_quantity)
        val tvDeliveryTime: TextView = view!!.findViewById(R.id.tv_deliveryData)

        tvStatus.text = detail.status.name
        tvDeliveryAdress.text = detail.address
        tvPayment.text = detail.payment.name
        tvBonusCard.text = detail.bonusCard.toString()
        tvPayedBonusesNumber.text = detail.amount.bonuses.toString()
        tvTotalNumber.text = detail.amount.total.toString()
        tvDiscountNumber.text = detail.amount.discount.toString()
        tvBuildDate.text = detail.deliveryTime.dateAndTime.date
        tvDeliveryTime.text = detail.deliveryTime.dateAndTime.time
//        tvRvProductQuantity.text = detail.detailItems.quantity

        val tvToolbar: TextView = view!!.findViewById(R.id.tv_toolbar_detail)
        val tvDataOrder: TextView = view!!.findViewById(R.id.tv_dataOrder)
        val tvDetailDelivery: TextView = view!!.findViewById(R.id.tv_detail_delivery)

        tvToolbar.text = arguments?.getString("number").orEmpty()
        tvDataOrder.text = arguments?.getInt("dateTime")?.format()
        tvDetailDelivery.text = arguments?.getString("delivery").orEmpty()
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    companion object {

        fun newInstance(
            id: String,
            productNumber: String,
            productDateTime: Int,
            productDelivery: String
        ): DetailFragment {

            val bundle = Bundle()
            bundle.putString("id", id)
            bundle.putString("number", productNumber)
            bundle.putInt("dateTime", productDateTime)
            bundle.putString("delivery", productDelivery)

            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}