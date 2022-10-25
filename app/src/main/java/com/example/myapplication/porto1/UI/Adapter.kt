package com.example.myapplication.porto1.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.myapplication.porto1.Response.Hotel
import com.example.myapplication.porto1.databinding.ItemHotelBinding

class Adapter: RecyclerView.Adapter<Adapter.ListViewModel>() {
    private val listHotel = ArrayList<Hotel>()
    private lateinit var onItemClickCallback : OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback : OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setList(users: ArrayList<Hotel>){
        listHotel.clear()
        listHotel.addAll(users)
    }
    inner class ListViewModel(private val binding: ItemHotelBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hotel: Hotel){
            binding.root.setOnClickListener{
                onItemClickCallback.onItemClicked(hotel)
            }
            binding.apply {
                Glide.with((itemView))
                    .load(hotel.gambar_url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .centerCrop()
                    .into(photoHotel)
                namaHotel.text = hotel.nama
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewModel {
        val view = ItemHotelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewModel((view))
    }

    override fun onBindViewHolder(holder: ListViewModel, position: Int) {
       holder.bind(listHotel[position])

    }

    override fun getItemCount(): Int = listHotel.size

    interface OnItemClickCallback{
        fun onItemClicked(hotel:Hotel)
    }
}