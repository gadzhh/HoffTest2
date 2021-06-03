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
import com.example.hofftest2.data.model.detailorder.DetailItems
import com.example.hofftest2.databinding.DetailProductItemsBinding

class DetailProductItemsAdapter :
    RecyclerView.Adapter<DetailProductItemsAdapter.DetailItemsHolder>() {

    private var items = ArrayList<DetailItems>()

    fun setDetailData(data: List<DetailItems>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    class DetailItemsHolder(private val itemBinding: DetailProductItemsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(items: DetailItems) {
            with(itemBinding) {
                ivProduct.load(items.image)
                tvName.text = items.name
                tvArticul.text = items.articul
                tvPrice.text = "${items.price} ₽"
                tvNumber.text = "${items.quantity} ШТ"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailItemsHolder {
        val itemBinding =
            DetailProductItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailItemsHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: DetailItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
