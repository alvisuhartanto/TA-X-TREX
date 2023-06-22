package com.example.snapchef.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.snapchef.databinding.ListItemsSubsBinding
import com.example.snapchef.model.Ingredients

class FlavourAdapter (val list: ArrayList<Ingredients>): RecyclerView.Adapter<FlavourAdapter.FalvourViewHolder>(){
    inner class FalvourViewHolder (val binding: ListItemsSubsBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(ingredients: Ingredients){
            with(binding){
                flavorName.text = ingredients.text
                flavorWieght.text = "${ingredients.weight} gram"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FalvourViewHolder {
        val binding = ListItemsSubsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FalvourViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FalvourViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}