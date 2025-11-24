package com.fanxin.work2.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fanxin.work2.R

class MeFragment : Fragment() {

    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_me, container, false)

        preferences = requireContext().getSharedPreferences("user", Context.MODE_PRIVATE)

        val username = preferences.getString("username", "")
        val signature = preferences.getString("signature", "")

        // 设置用户名和签名
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvSignature = view.findViewById<TextView>(R.id.tv_signature)
        
        // 如果从SharedPreferences读取到了值，就显示；否则显示默认值
        tvName.text = username?.takeIf { it.isNotEmpty() } ?: "用户名"
        tvSignature.text = signature?.takeIf { it.isNotEmpty() } ?: "欢迎来到信息APP"

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
