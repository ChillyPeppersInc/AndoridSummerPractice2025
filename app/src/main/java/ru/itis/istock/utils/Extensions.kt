package ru.itis.istock.utils

import android.os.Build
import androidx.fragment.app.Fragment

fun String.doSomething(
    arg1: Int
): Int {
    return this.length + arg1
}

inline fun <reified T> Fragment.getParcelable(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arguments?.getParcelable(key, T::class.java)
    } else {
        arguments?.getParcelable(key) as? T
    }
}