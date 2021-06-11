package com.jiannlee22.navigationdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.jiannlee22.navigationdemo.R
import com.jiannlee22.navigationdemo.databinding.FragmentCommonBinding

/**
 * Created by JIAnnLee22 on 2021/06/08 19:19
 * 说明:
 */
class FragmentA : Fragment() {
    private lateinit var rootView: ViewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = FragmentCommonBinding.inflate(inflater, container, false)
        initView(container)
        return rootView.root
    }

    private fun initView(container: ViewGroup?) {
        val text = TextView(requireContext())
        text.text = "FragmentA"
        val buttonNext = Button(requireContext())
        container?.addView(text)
        container?.addView(buttonNext)
        buttonNext.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
        }
    }
}