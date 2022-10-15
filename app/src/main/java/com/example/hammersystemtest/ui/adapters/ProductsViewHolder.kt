package com.example.hammersystemtest.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammersystemtest.data.database.Food
import com.example.hammersystemtest.databinding.ItemProductBinding

class ProductsViewHolder(
    private val binding: ItemProductBinding
): RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(food: Food, context: Context){
        binding.apply {
            Glide
                .with(context)
                .load(food.images)
                .into(productImage)
            productTitle.text = food.title
            productDescription.text = food.description
            productPrice.text = "from ${food.price} RUB"
        }
        Log.d("ViewHolder", food.title)
    }
}