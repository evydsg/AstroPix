package com.driuft.random_pets_starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NasaAdapter (private val nasaList: MutableList<Triple<String,String,String>>): RecyclerView.Adapter<NasaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nasaImage: ImageView
        val nasaDate: TextView
        val nasaTitle: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            nasaImage = view.findViewById(R.id.nasa_image)
            nasaDate = view.findViewById(R.id.nasa_date)
            nasaTitle = view.findViewById(R.id.nasa_title)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nasa_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.nasaImage.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Nasa picture at position $position clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
        Glide.with(holder.itemView)
            .load(nasaList[position].first)
            .centerCrop()
            .into(holder.nasaImage)

        holder.nasaDate.text= nasaList[position].second
        holder.nasaTitle.text = nasaList[position].third
    }

        override fun getItemCount() = nasaList.size
    }



