package com.example.hofftest2.presentation.order.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofftest2.R
import com.example.hofftest2.data.model.listorder.OrderItems
import com.example.hofftest2.utils.format


class OrderItemsAdapter(clickListener: ClickListener):
    RecyclerView.Adapter<OrderItemsAdapter.OrderItemsHolder>() {

    private var items = ArrayList<OrderItems>()

    val dListener: ClickListener = clickListener

    fun setData(data: List<OrderItems>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    inner class OrderItemsHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val tvNumber: TextView = itemView.findViewById(R.id.tv_number)
        private val tvData: TextView = itemView.findViewById(R.id.tv_data)
        private val tvStatus: TextView = itemView.findViewById(R.id.tv_status)
        private val tvDelivery: TextView = itemView.findViewById(R.id.tv_delivery)
        private val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        private val ivDelivery: ImageView = itemView.findViewById(R.id.iv_delivery)

        fun bind(item: OrderItems) {

            tvNumber.text = "№ ${item.number}"
            tvData.text = item.dateTime.format()
            tvStatus.text = item.orderStatus.name
            ivDelivery.load(item.delivery.icon)
            tvDelivery.text = item.delivery.name
            tvPrice.text = "${item.sum} ₽"

            tvPrice.setOnClickListener {
                dListener.buttonClick(item.id, item.number, item.dateTime, item.delivery.name)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_items, parent, false)
        return OrderItemsHolder(view)
    }

    override fun onBindViewHolder(holder: OrderItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
