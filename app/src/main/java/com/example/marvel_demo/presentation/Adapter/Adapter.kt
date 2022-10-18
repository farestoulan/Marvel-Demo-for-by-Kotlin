package com.example.marvel_demo.presentation.Adapter

import com.example.marvel_demo.presentation.Adapter.Adapter.MyViewHolder
import com.example.marvel_demo.data.ModelClasses.ListModelClass
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel_demo.R

class Adapter(private val mContext: Context, private var data: MutableList<ListModelClass?>) :
    RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var mClickListener: ItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v: View
        val inflater = LayoutInflater.from(mContext)
        v = inflater.inflate(R.layout.fragment_item_list, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(mContext).load(
            data[position]?.thumbnail?.path + "." +
                    data[position]?.thumbnail?.extension
        ).into(holder.path)
    }

    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int, data: MutableList<ListModelClass?>)
    }

    fun setClickListener(itemClickListener: ItemClickListener) {
        mClickListener = itemClickListener
    }

    override fun getItemCount(): Int {
        return data.size
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var path: ImageView

        override fun onClick(p0: View?) {

            p0?.let { mClickListener.onItemClick(it, position, data) }
        }

        init {
            path = itemView.findViewById(R.id.imageView)
            itemView.setOnClickListener(this)
        }
    }

    init {
        this.data = data
    }
}