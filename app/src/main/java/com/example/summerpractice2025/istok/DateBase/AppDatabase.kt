package com.example.summerpractice2025.istok.DateBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.summerpractice2025.istok.DateBase.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}