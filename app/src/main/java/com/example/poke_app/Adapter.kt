package com.example.poke_app

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.poke_app.databinding.ActivityItemBinding

class Adapter(): ListAdapter<Pokemon, Adapter.PokemonViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ActivityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class PokemonViewHolder(private val binding: ActivityItemBinding):
        RecyclerView.ViewHolder(binding.root){
            fun bind(pokemon: Pokemon){
                binding.nomeItem.text = pokemon.name


            }


    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.name == newItem.name
            }
            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem == newItem
            }
        }
    }

}