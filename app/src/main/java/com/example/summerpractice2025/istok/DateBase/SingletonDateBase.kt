package com.example.summerpractice2025.istok.DateBase

import com.example.summerpractice2025.istok.DateBase.AppDatabase
import com.example.summerpractice2025.istok.DateBase.UserDao
import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.summerpractice2025.istok.DateBase.User

object DatabaseManager {
    private lateinit var appContext: Application
    private lateinit var database: AppDatabase

    // инициализация (вызывать 1 раз в Application классе)
    fun init(context: Context) {
        if (!::database.isInitialized) {
            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database.db"
            ).build()
        }
    }

    // получение DAO
    val userDao: UserDao get() = database.userDao()
}