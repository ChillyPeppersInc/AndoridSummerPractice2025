package ru.itis.istock.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDataModel(
    val username: String,
    val password: String,
    val address: String,
): Parcelable {
    override fun toString(): String {
        return "Username: $username; Password: $password; Address: $address"
    }
}
