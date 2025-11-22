package com.fanxin.work2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fanxin.work2.R

class MeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_me, container, false)
        
        // 设置点击事件
        view.findViewById<View>(R.id.ll_me_information).setOnClickListener {
            Toast.makeText(context, "个人信息", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.ll_me_collect).setOnClickListener {
            Toast.makeText(context, "我的收藏", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.ll_me_history).setOnClickListener {
            Toast.makeText(context, "浏览历史", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.ll_me_settings).setOnClickListener {
            Toast.makeText(context, "设置", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.ll_me_about_us).setOnClickListener {
            Toast.makeText(context, "关于我们", Toast.LENGTH_SHORT).show()
        }
        
        view.findViewById<View>(R.id.ll_me_feedback).setOnClickListener {
            Toast.makeText(context, "意见反馈", Toast.LENGTH_SHORT).show()
        }
        
        return view
    }
}
