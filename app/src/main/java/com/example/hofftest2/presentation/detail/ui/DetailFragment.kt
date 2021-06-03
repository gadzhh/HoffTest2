package com.example.hofftest2.presentation.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hofftest2.App
import com.example.hofftest2.data.model.detailorder.OrderDetail
import com.example.hofftest2.databinding.FragmentDetailBinding
import com.example.hofftest2.presentation.Screens
import com.example.hofftest2.presentation.detail.mvp.DetailPresenter
import com.example.hofftest2.presentation.detail.mvp.DetailView
import com.example.hofftest2.presentation.detail.ui.adapter.DetailProductItemsAdapter
import com.example.hofftest2.presentation.detail.ui.adapter.DetailServiceItemsAdapter
import com.example.hofftest2.utils.format
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class DetailFragment : Fragment(), DetailView {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var detailProductsAdapter: DetailProductItemsAdapter
    private lateinit var detailServicesAdapter: DetailServiceItemsAdapter

    @Inject
    lateinit var presenter: DetailPresenter

    @Inject
    lateinit var router: Router

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
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

        binding.rvProducts.adapter = detailProductsAdapter
        binding.rvServices.adapter = detailServicesAdapter

        binding.toolbarDetail.setNavigationOnClickListener {
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
        binding.detailProgress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.detailProgress.visibility = View.GONE
    }

    override fun showData(detail: OrderDetail) {

        detailProductsAdapter.setDetailData(detail.detailItems)
        detailServicesAdapter.setServicesData(detail.services)

        with(binding) {
            tvStatusDetail.text = detail.status.name
            tvDeliveryAdress.text = detail.address
            tvPayment.text = detail.payment.name
            tvBonusCard.text = detail.bonusCard.toString()
            tvPayedBonusesNumber.text = detail.amount.bonuses.toString()
            tvTotalNumber.text = detail.amount.total.toString()
            tvDiscountNumber.text = detail.amount.discount.toString()
            tvBuildDate.text = detail.deliveryTime.dateAndTime.date
            tvDeliveryData.text = detail.deliveryTime.dateAndTime.time
            tvToolbarDetail.text = arguments?.getString("number").orEmpty()
            tvDataOrder.text = arguments?.getInt("dateTime")?.format()
            tvDetailDelivery.text = arguments?.getString("delivery").orEmpty()
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}