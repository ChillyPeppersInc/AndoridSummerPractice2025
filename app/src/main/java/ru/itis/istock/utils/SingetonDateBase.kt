package ru.itis.istock.utils

import AppDatabase
import UserDao
import android.app.Application
import android.content.Context
import androidx.room.Room
import ru.itis.istock.DataBase.User

object DatabaseManager {
    private lateinit var appContext: Application
    private lateinit var database: AppDatabase

    // Инициализация (вызывать 1 раз в Application классе)
    fun init(context: Context) {
        if (database == null) {
            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database.db"
            ).build()
        }
    }

    // Получение DAO
    val userDao: UserDao get() = database.userDao()
}