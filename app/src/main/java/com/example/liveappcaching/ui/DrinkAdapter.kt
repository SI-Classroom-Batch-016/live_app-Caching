package com.example.liveappcaching.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.liveappcaching.R
import com.example.liveappcaching.data.model.Drink
import com.example.liveappcaching.databinding.DrinkItemBinding



class DrinkAdapter(
    val dataset: List<Drink>,
    val onDrinkClicked: (Drink) -> Unit
) : RecyclerView.Adapter<DrinkAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: DrinkItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = DrinkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.drinkNameTV.text = item.name
        holder.binding.drinkThumbnailIV.load(item.thumbnail) {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_background)
        }

        holder.binding.drinkCV.setOnClickListener {
            onDrinkClicked(item)
        }

    }

}