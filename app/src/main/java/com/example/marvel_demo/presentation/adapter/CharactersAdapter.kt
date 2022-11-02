package com.example.marvel_demo.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_demo.R
import com.example.marvel_demo.data.models.CharacterModel
import com.example.marvel_demo.presentation.adapter.CharactersAdapter.MyViewHolder

class CharactersAdapter(private val mClickListener: ItemClickListener) :
    RecyclerView.Adapter<MyViewHolder>() {

    private val charactersList = mutableListOf<CharacterModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View
        val inflater = LayoutInflater.from(parent.context)
        v = inflater.inflate(R.layout.fragment_item_list, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }

    interface ItemClickListener {
        fun onItemClick(data: CharacterModel)
    }

    override fun getItemCount() = charactersList.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(model: CharacterModel) {
            val path: ImageView = itemView.findViewById(R.id.imageView)

            Glide.with(itemView.context).load(
                model.thumbnail.path + "." + model.thumbnail.extension
            ).into(path)

            itemView.setOnClickListener {
                mClickListener.onItemClick(charactersList[adapterPosition])
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<CharacterModel>){
        charactersList.addAll(list)
        notifyDataSetChanged()
    }
}