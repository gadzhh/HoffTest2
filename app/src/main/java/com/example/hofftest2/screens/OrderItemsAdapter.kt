package com.example.hofftest2.screens

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hofftest2.R
import com.example.hofftest2.data.model.Order


class OrderItemsAdapter : RecyclerView.Adapter<OrderItemsAdapter.OrderItemsHolder>() {

    private val items = ArrayList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_items, parent, false)
        return OrderItemsHolder(view)
    }

    override fun onBindViewHolder(holder: OrderItemsHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class OrderItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Order) {

        }
    }
}
