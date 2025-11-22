package com.fanxin.work2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<android.view.View>(R.id.ll_me_information).setOnClickListener {
            Toast.makeText(this, "个人信息", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.ll_me_collect).setOnClickListener {
            Toast.makeText(this, "我的收藏", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.ll_me_history).setOnClickListener {
            Toast.makeText(this, "浏览历史", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.ll_me_settings).setOnClickListener {
            Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.ll_me_about_us).setOnClickListener {
            Toast.makeText(this, "关于我们", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.ll_me_feedback).setOnClickListener {
            Toast.makeText(this, "意见反馈", Toast.LENGTH_SHORT).show()
        }
    }
}