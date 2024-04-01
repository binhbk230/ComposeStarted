package com.bstudio.composestarted.util

import android.content.Context
import android.content.SharedPreferences

class SharePrefManager(context: Context) {
    companion object {
        const val SHARE_PREF_NAME = "compose_started_pref"
        const val THEME_KEY = "THEME_KEY"
    }
    private val sharedPreferences = context.getSharedPreferences(SHARE_PREF_NAME, Context.MODE_PRIVATE)

    fun registerOnSharePrefChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    fun unRegisterOnSharePrefChangeListener(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
    }

    fun getString(key: String, defaultValue: String = "") : String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun putString(key: String, value: String)  {
        sharedPreferences.edit().putString(key, value).apply()
    }
}