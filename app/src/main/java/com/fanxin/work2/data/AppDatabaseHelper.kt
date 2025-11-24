package com.fanxin.work2.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.mindrot.jbcrypt.BCrypt

class AppDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "MyApp.db"
        private const val DATABASE_VERSION = 1

        // 用户表
        const val TABLE_USERS = "db_user"
        const val COLUMN_ID = "_id"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PASSWORD_HASH = "password_hash"
        const val COLUMN_NICKNAME = "nickname"

        // 创建用户表的SQL语句
        private const val CREATE_TABLE_USERS = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_EMAIL TEXT NOT NULL UNIQUE,
                $COLUMN_PASSWORD_HASH TEXT NOT NULL,
                $COLUMN_NICKNAME TEXT DEFAULT '用户'
            );
        """
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_USERS)
        prepopulateDefaultUsers(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // 如果数据库版本升级，在这里处理表结构的变更
        // db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        // onCreate(db)
    }

    /**
     * 预填充默认用户（可选）
     */
    fun prepopulateDefaultUsers(db: SQLiteDatabase) {
        val adminPassword = "Aa123123"
        val hashedAdminPassword = BCrypt.hashpw(adminPassword, BCrypt.gensalt())

        val sql = """
            INSERT INTO $TABLE_USERS ($COLUMN_EMAIL, $COLUMN_PASSWORD_HASH, $COLUMN_NICKNAME)
            VALUES ('admin@test.com', '$hashedAdminPassword', '江在程');
        """.trimIndent()

        db.execSQL(sql)
    }
}