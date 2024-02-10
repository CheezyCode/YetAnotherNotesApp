package com.cheezycode.notesample.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.cheezycode.notesample.utils.Constants.PREFS_TOKEN_FILE
import com.cheezycode.notesample.utils.Constants.USER_TOKEN

class TokenManager(context: Application) {
    private var prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun getToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}