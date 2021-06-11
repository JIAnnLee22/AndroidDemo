package com.jiannlee22.androiddemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.jiannlee22.androiddemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //视图绑定
    val mBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        //第一列相同合并
        //第二列相同并且第一列相同,合并
    }
}