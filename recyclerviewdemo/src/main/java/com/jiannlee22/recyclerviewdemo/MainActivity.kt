package com.jiannlee22.recyclerviewdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jiannlee22.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }

    override fun onResume() {
        super.onResume()
        //val items = mutableListOf("first", "second")
        val items = mutableListOf("数据1", "数据2", "数据3", "数据4", "数据5")
        //val adapter = MyAdapter(items)
        val adapter = ListAdapter(items)
        mBinding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }
        mBinding.setWrong.setOnClickListener {
            //Toast.makeText(this, adapter.contentText, Toast.LENGTH_SHORT).show()
            adapter.wrongItems = mutableListOf(0, 2, 4)
            adapter.notifyDataSetChanged()
        }
        mBinding.clearWrong.setOnClickListener {
            //Toast.makeText(this, adapter.contentText, Toast.LENGTH_SHORT).show()
            adapter.wrongItems = mutableListOf()
            adapter.notifyDataSetChanged()
        }
    }
}