package com.jiannlee22.recyclerviewdemo

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.recyclerviewdemo.databinding.ListItemViewBinding

/**
 * Created by JIAnnLee22 on 2021/06/11 15:53
 * 说明:
 */
class ListAdapter constructor(private val itemList: MutableList<String>) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var wrongItems = mutableListOf<Int>()

    class MyViewHolder(itemView: ListItemViewBinding) : RecyclerView.ViewHolder(itemView.root) {
        val title = itemView.tvTitle
        val backGround = itemView.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var flag = false
        wrongItems.forEach {
            if (position == it) {
                flag = true
            }
        }
        if (flag) {
            holder.backGround.setBackgroundColor(Color.RED)
        } else {
            holder.backGround.setBackgroundColor(Color.WHITE)
        }
        holder.title.text = itemList[position]
    }

    override fun getItemCount() = itemList.size

}