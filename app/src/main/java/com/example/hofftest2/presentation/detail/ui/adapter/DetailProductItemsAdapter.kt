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

class DetailProductItemsAdapter :
    RecyclerView.Adapter<DetailProductItemsAdapter.DetailItemsHolder>() {

    private var items = ArrayList<DetailItems>()

    fun setDetailData(data: List<DetailItems>) {
        this.items.addAll(data)

        notifyDataSetChanged()
    }

    class DetailItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val ivProduct: ImageView = itemView.findViewById(R.id.iv_product)
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvArticul: TextView = itemView.findViewById(R.id.tv_articul)
        private val tvPrice: TextView = itemView.findViewById(R.id.tv_price)
        private val tvNumber: TextView = itemView.findViewById(R.id.tv_number)

        fun bind(items: DetailItems) {
            ivProduct.load(items.image)
            tvName.text = items.name
            tvArticul.text = items.articul
            tvPrice.text = "${items.price} ₽"
            tvNumber.text = "${items.quantity} ШТ"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailItemsHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detail_product_items, parent, false)
        return DetailItemsHolder(view)
    }

    override fun onBindViewHolder(holder: DetailItemsHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}
