package com.app.recipe.utils

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

inline fun <reified T> String.fromJson(): T = Gson().fromJson(this, T::class.java)

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun Fragment.showToast(message: String?, length: Int = Toast.LENGTH_SHORT) =
        message?.let {
            Toast.makeText(requireContext(), message, length).show()
        }

fun Activity.showToast(message: String?, length: Int = Toast.LENGTH_SHORT) =
        message?.let {
            Toast.makeText(this, message, length).show()
        }

fun Date.formatTo(dateFormat: String): String {
    val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
    return formatter.format(this)
}

fun Date.isBetweenDays(days: Int): Boolean {
    return Date().compareTo(this) * this.compareTo(Calendar.getInstance().getDaysSubtracted(days)) > 0;
}

fun Calendar.getDaysSubtracted(days: Int): Date {
    set(Calendar.DAY_OF_MONTH, get(Calendar.DAY_OF_MONTH) - days)
    return time
}