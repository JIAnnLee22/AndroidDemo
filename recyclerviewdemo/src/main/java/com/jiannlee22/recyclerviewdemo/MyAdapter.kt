package com.jiannlee22.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.jiannlee22.recyclerviewdemo.databinding.ItemViewBinding

/**
 * Created by JIAnnLee22 on 2021/06/11 15:53
 * 说明:
 */
class MyAdapter constructor(private val itemList: MutableList<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var contentText: String = ""

    class MyViewHolder(itemView: ItemViewBinding) : RecyclerView.ViewHolder(itemView.root) {
        val title = itemView.tvTitle
        val content = itemView.etContent
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = itemList[position]
        holder.content.doAfterTextChanged {
            contentText = it.toString()
        }
    }

    override fun getItemCount() = itemList.size

}