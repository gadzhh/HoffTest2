package com.example.hofftest2.presentation.detail.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hofftest2.R
import com.example.hofftest2.data.model.detailorder.Services

class DetailServiceItemsAdapter :
    RecyclerView.Adapter<DetailServiceItemsAdapter.ServicesItemsHolder>() {

    private var items = ArrayList<Services>()

    fun setServicesData(data: List<Services>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    class ServicesItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivIcon: ImageView = itemView.findViewById(R.id.iv_icon)
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPrice: TextView = itemView.findViewById(R.id.tv_price)

        @SuppressLint("SetTextI18n")
        fun bind(items: Services) {
            ivIcon.load(items.icon)
            tvName.text = items.name
            tvPrice.text = "${items.price} ₽"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesItemsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_services_items, parent, false)
        return ServicesItemsHolder(view)
    }

    override fun onBindViewHolder(holder: ServicesItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}