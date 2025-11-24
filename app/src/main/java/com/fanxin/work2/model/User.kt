package com.fanxin.work2.model

data class User(
    val id: Int = 0,
    val email: String,
    val passwordHash: String,
    val nickname: String = "用户"
)