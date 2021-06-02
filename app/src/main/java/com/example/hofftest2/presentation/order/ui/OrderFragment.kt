package com.example.hofftest2.presentation.order.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hofftest2.App
import com.example.hofftest2.R
import com.example.hofftest2.data.model.listorder.OrderList
import com.example.hofftest2.presentation.detail.ui.DetailFragment
import com.example.hofftest2.presentation.order.ui.adapter.ClickListener
import com.example.hofftest2.presentation.order.mvp.OrderPresenter
import com.example.hofftest2.presentation.order.mvp.OrderView
import com.example.hofftest2.presentation.order.ui.adapter.OrderItemsAdapter
import javax.inject.Inject

class OrderFragment : Fragment(), OrderView, ClickListener {

    private lateinit var adapter: OrderItemsAdapter
    private lateinit var progress: FrameLayout
    private lateinit var rv: RecyclerView

    @Inject
    lateinit var presenter: OrderPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_order, container, false)
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
        adapter = OrderItemsAdapter(this)
        progress = view.findViewById(R.id.progress)
        rv = view.findViewById(R.id.rv_order)
        rv.adapter = adapter
    }

    private fun initPresenter() {
        if (adapter.itemCount == 0)
            presenter.attachView(this)
    }

    override fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress.visibility = View.GONE
    }

    override fun showOrders(orders: OrderList) {
        adapter.setData(orders.orderItems)
    }

    override fun showError(error: String) {
        Toast.makeText(context, error, LENGTH_SHORT).show()
    }

    override fun buttonClick(
        id: String,
        productNumber: String,
        productDateTime: Int,
        productDelivery: String
    ) {
        val bundle = Bundle()
        bundle.putString("id", id)
        bundle.putString("number", productNumber)
        bundle.putInt("dateTime", productDateTime)
        bundle.putString("delivery", productDelivery)

        val fragment = DetailFragment()
        fragment.arguments = bundle

        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(R.id.container_for_fragment, fragment)
            ?.commit()
    }
}