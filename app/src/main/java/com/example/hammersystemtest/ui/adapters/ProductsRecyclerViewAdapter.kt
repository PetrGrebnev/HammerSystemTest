package com.example.hammersystemtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemtest.data.database.Food
import com.example.hammersystemtest.databinding.ItemProductBinding

class ProductsRecyclerViewAdapter : RecyclerView.Adapter<ProductsViewHolder>(){

    private var list = mutableListOf<Food>()

    fun setData(newList: List<Food>){
        val diffUtil = ProductDIffUtilsAdapter(list, newList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        list = newList as MutableList<Food>
        diffResults.dispatchUpdatesTo(this )
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        return ProductsViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        list[position].let { item ->
            holder.bind(item, holder.itemView.context)
        }
    }

    override fun getItemCount(): Int = list.size
}