package com.example.serinoquestion1

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PriceListAdapter(
    private val items: Array<String>,
    private val prices: IntArray
): Adapter<PriceListAdapter.PriceListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PriceListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_price_list, parent, false)
        return PriceListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }

    override fun onBindViewHolder(holder: PriceListViewHolder, position: Int) {
        if(position < items.size) {
            holder.bindPrice(item = items[position], price = prices[position])
        }else{
            holder.bindTotal(prices)
        }
    }

    inner class PriceListViewHolder(itemView: View): ViewHolder(itemView) {

        private val textItem: TextView = itemView.findViewById(R.id.textItem)
        private val textPrice: TextView = itemView.findViewById(R.id.textPrice)

        fun bindPrice(item: String, price: Int) {
            textItem.text = item
            textPrice.text = "$$price.00"
            setTypeFace(Typeface.NORMAL)
        }

        fun bindTotal(prices: IntArray) {
            val total = prices.sum()
            textItem.text = "Total"
            textPrice.text = "$$total.00"
            setTypeFace(Typeface.BOLD)
        }

        private fun setTypeFace(typeface: Int) {
            textItem.setTypeface(null, typeface);
            textPrice.setTypeface(null, typeface);
        }
    }
}

