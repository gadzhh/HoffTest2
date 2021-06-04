package com.example.hofftest2.presentation.order.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofftest2.data.model.listorder.OrderItems
import com.example.hofftest2.databinding.OrderItemsBinding
import com.example.hofftest2.utils.dateTimeFormat

class OrderItemsAdapter(clickListener: ClickListener) :
    RecyclerView.Adapter<OrderItemsAdapter.OrderItemsHolder>() {

    private var items = ArrayList<OrderItems>()

    val dListener: ClickListener = clickListener

    fun setData(data: List<OrderItems>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    inner class OrderItemsHolder(private val itemBinding: OrderItemsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: OrderItems) {
            with(itemBinding) {
                tvNumber.text = "№ ${item.number}"
                tvData.text = item.dateTime.dateTimeFormat()
                tvStatus.text = item.orderStatus.name
                ivDelivery.load(item.delivery.icon)
                tvDelivery.text = item.delivery.name
                tvPrice.text = "${item.sum} ₽"

                tvPrice.setOnClickListener {
                    dListener.buttonClick(item.orderId, item.number, item.dateTime, item.delivery.name)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemsHolder {
        val itemBinding =
            OrderItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderItemsHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: OrderItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
