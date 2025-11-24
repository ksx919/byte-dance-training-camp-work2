package com.fanxin.work2.repository

import android.database.Cursor
import com.fanxin.work2.data.AppDatabaseHelper
import com.fanxin.work2.model.User
import org.mindrot.jbcrypt.BCrypt

class UserRepository(private val dbHelper: AppDatabaseHelper) {

    /**
     * 用户登录验证
     * @return 如果验证成功，返回User对象，否则返回null
     */
    fun loginUser(email: String, plainPassword: String): User? {
        val db = dbHelper.readableDatabase
        var user: User? = null

        val projection = arrayOf(
            AppDatabaseHelper.COLUMN_ID,
            AppDatabaseHelper.COLUMN_EMAIL,
            AppDatabaseHelper.COLUMN_PASSWORD_HASH,
            AppDatabaseHelper.COLUMN_NICKNAME
        )

        val selection = "${AppDatabaseHelper.COLUMN_EMAIL} = ?"
        val selectionArgs = arrayOf(email)

        val cursor: Cursor = db.query(
            AppDatabaseHelper.TABLE_USERS,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        with(cursor) {
            if (moveToFirst()) {
                val storedPasswordHash = getString(getColumnIndexOrThrow(AppDatabaseHelper.COLUMN_PASSWORD_HASH))

                if (BCrypt.checkpw(plainPassword, storedPasswordHash)) {
                    user = User(
                        id = getInt(getColumnIndexOrThrow(AppDatabaseHelper.COLUMN_ID)),
                        email = getString(getColumnIndexOrThrow(AppDatabaseHelper.COLUMN_EMAIL)),
                        passwordHash = storedPasswordHash,
                        nickname = getString(getColumnIndexOrThrow(AppDatabaseHelper.COLUMN_NICKNAME))
                    )
                }
            }
        }
        cursor.close()
        db.close()

        return user
    }
}