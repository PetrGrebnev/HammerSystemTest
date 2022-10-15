package com.example.hammersystemtest.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemtest.databinding.ItemCategoryBinding

class CategoryRecyclerViewAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    private var listTitle = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        listTitle[position].let { item ->
            holder.bind(item)
        }
    }

    override fun getItemCount(): Int = listTitle.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<String>) {
        this.listTitle = list as MutableList<String>
        notifyDataSetChanged()
    }
}