package com.example.summerpractice2025.istok.DateBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>?

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>?

    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    suspend fun findByEmail(email: String): User?

    @Insert
    suspend fun insertAll(vararg users: User)

    @Insert
    suspend fun insert(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT COUNT(*) FROM user WHERE email = :email")
    suspend fun getUserCountByEmail(email: String): Int

    suspend fun userExists(email: String): Boolean {
        return getUserCountByEmail(email) > 0
    }
}