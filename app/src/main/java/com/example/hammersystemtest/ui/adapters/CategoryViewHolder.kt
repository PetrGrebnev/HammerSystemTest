package com.example.hammersystemtest.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystemtest.databinding.ItemCategoryBinding

class CategoryViewHolder(
    private val binding: ItemCategoryBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String){
        binding.apply{
            categoryTitle.text = item
        }
    }
}