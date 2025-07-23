package com.example.summerpractice2025

import android.app.Application
import com.example.summerpractice2025.istok.DateBase.DatabaseManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseManager.init(this)
    }
}