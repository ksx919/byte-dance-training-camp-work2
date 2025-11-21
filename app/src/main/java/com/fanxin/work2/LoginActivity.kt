package com.fanxin.work2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<android.view.View>(R.id.btn_wechat_login).setOnClickListener {
            Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.btn_apple_login).setOnClickListener {
            Toast.makeText(this, "Apple登录", Toast.LENGTH_SHORT).show()
        }
    }


}