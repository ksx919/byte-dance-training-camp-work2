package com.fanxin.work2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.fanxin.work2.data.AppDatabaseHelper
import com.fanxin.work2.repository.UserRepository

class LoginActivity : AppCompatActivity() {

    private lateinit var preferences: SharedPreferences

    private lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val dbHelper = AppDatabaseHelper(this)
        userRepository = UserRepository(dbHelper)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        preferences = getSharedPreferences("user", MODE_PRIVATE)

        findViewById<android.view.View>(R.id.btn_wechat_login).setOnClickListener {
            Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.btn_apple_login).setOnClickListener {
            Toast.makeText(this, "Apple登录", Toast.LENGTH_SHORT).show()
        }

        findViewById<android.view.View>(R.id.btn_login).setOnClickListener {
            val email = findViewById<android.widget.EditText>(R.id.et_email).text.toString()
            val password = findViewById<android.widget.EditText>(R.id.et_password).text.toString()
            val loggedInUser = userRepository.loginUser(email, password)
            if (loggedInUser != null) {
                Toast.makeText(this, "欢迎回来，${loggedInUser.nickname}！", Toast.LENGTH_SHORT).show()
                // 登录成功，跳转到主界面
                val editor = preferences.edit()
                editor.putString("username", "江在程")
                editor.putString("signature", "这是一条签名~")
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "邮箱或密码错误。", Toast.LENGTH_SHORT).show()
            }

        }
    }


}