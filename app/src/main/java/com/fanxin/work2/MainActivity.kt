package com.fanxin.work2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.fanxin.work2.fragment.HomeFragment
import com.fanxin.work2.fragment.InformationFragment
import com.fanxin.work2.fragment.MeFragment

class MainActivity : AppCompatActivity() {
    
    private lateinit var btnHome: android.view.View
    private lateinit var btnInformation: android.view.View
    private lateinit var btnMe: android.view.View
    
    private lateinit var ivHome: ImageView
    private lateinit var ivInformation: ImageView
    private lateinit var ivMe: ImageView
    
    private lateinit var tvHome: TextView
    private lateinit var tvInformation: TextView
    private lateinit var tvMe: TextView
    
    private var currentFragment: Fragment? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        setupBottomNavigation()
        
        // 默认显示"我的"页面
        switchToFragment(MeFragment(), "me")
        updateBottomNavigationState("me")
    }
    
    private fun initViews() {
        btnHome = findViewById(R.id.btn_home)
        btnInformation = findViewById(R.id.btn_information)
        btnMe = findViewById(R.id.btn_me)
        
        ivHome = findViewById(R.id.iv_home)
        ivInformation = findViewById(R.id.iv_information)
        ivMe = findViewById(R.id.iv_me)
        
        tvHome = findViewById(R.id.tv_home)
        tvInformation = findViewById(R.id.tv_information)
        tvMe = findViewById(R.id.tv_me)
    }
    
    private fun setupBottomNavigation() {
        btnHome.setOnClickListener {
            switchToFragment(HomeFragment(), "home")
            updateBottomNavigationState("home")
        }
        
        btnInformation.setOnClickListener {
            switchToFragment(InformationFragment(), "information")
            updateBottomNavigationState("information")
        }
        
        btnMe.setOnClickListener {
            switchToFragment(MeFragment(), "me")
            updateBottomNavigationState("me")
        }
    }
    
    private fun switchToFragment(fragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        
        // 如果Fragment已经存在，则替换；否则添加
        val existingFragment = fragmentManager.findFragmentByTag(tag)
        if (existingFragment != null) {
            transaction.replace(R.id.fragment_container, existingFragment, tag)
        } else {
            transaction.replace(R.id.fragment_container, fragment, tag)
        }
        
        transaction.commit()
        currentFragment = fragment
    }
    
    private fun updateBottomNavigationState(selectedTab: String) {
        // 重置所有状态为未选中
        ivHome.setImageResource(R.mipmap.ic_home_unselected)
        ivInformation.setImageResource(R.mipmap.ic_information_unselected)
        ivMe.setImageResource(R.mipmap.ic_me_unselected)
        
        tvHome.setTextColor(getColor(R.color.gray))
        tvInformation.setTextColor(getColor(R.color.gray))
        tvMe.setTextColor(getColor(R.color.gray))
        
        // 设置选中状态
        when (selectedTab) {
            "home" -> {
                ivHome.setImageResource(R.mipmap.ic_home_selected)
                tvHome.setTextColor(getColor(R.color.blue))
            }
            "information" -> {
                ivInformation.setImageResource(R.mipmap.ic_information_selected)
                tvInformation.setTextColor(getColor(R.color.blue))
            }
            "me" -> {
                ivMe.setImageResource(R.mipmap.ic_me_selected)
                tvMe.setTextColor(getColor(R.color.blue))
            }
        }
    }
}