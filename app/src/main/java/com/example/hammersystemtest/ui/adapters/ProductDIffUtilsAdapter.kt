package com.example.hammersystemtest.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.hammersystemtest.data.database.Food

class ProductDIffUtilsAdapter(
    private val oldList: List<Food>,
    private val newList: List<Food>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]

    }
}