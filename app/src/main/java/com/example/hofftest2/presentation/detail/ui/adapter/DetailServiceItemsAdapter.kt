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
import com.example.hofftest2.databinding.DetailServicesItemsBinding

class DetailServiceItemsAdapter :
    RecyclerView.Adapter<DetailServiceItemsAdapter.ServicesItemsHolder>() {

    private var items = ArrayList<Services>()

    fun setServicesData(data: List<Services>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    class ServicesItemsHolder(private val itemBinding: DetailServicesItemsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(items: Services) {
            with(itemBinding) {
                ivIcon.load(items.icon)
                tvName.text = items.name
                tvPrice.text = "${items.price} ₽"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesItemsHolder {
        val itemsBinding =
            DetailServicesItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ServicesItemsHolder(itemsBinding)
    }

    override fun onBindViewHolder(holder: ServicesItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}