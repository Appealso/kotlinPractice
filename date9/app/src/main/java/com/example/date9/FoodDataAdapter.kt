package com.example.date9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food.view.*

class FoodDataAdapter (val list: List<FoodModel>): RecyclerView.Adapter<FoodDataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food,parent,false)
        return FoodDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.count()
    }

    override fun onBindViewHolder(holder: FoodDataViewHolder, position: Int) {
        holder.containerView.nameText.text=list[position].name
        holder.containerView.priceText.text="${list[position].price}원"
    }
}