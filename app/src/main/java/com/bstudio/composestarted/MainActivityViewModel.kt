package com.bstudio.composestarted

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.bstudio.composestarted.ui.theme.StartedTheme
import com.bstudio.composestarted.util.SharePrefManager
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel(private val sharePrefManager: SharePrefManager): ViewModel(), SharedPreferences.OnSharedPreferenceChangeListener {

    private val _themeState = MutableStateFlow(StartedTheme.LIGHT)

    init {
        sharePrefManager.registerOnSharePrefChangeListener(this)
        val settingTheme: StartedTheme = StartedTheme.valueOf(sharePrefManager.getString(SharePrefManager.THEME_KEY, StartedTheme.LIGHT.name))
        _themeState.value = settingTheme
    }
    val themeState: StartedTheme
        @Composable
        get() = _themeState.collectAsState().value
    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if (key == SharePrefManager.THEME_KEY) {
            val settingTheme: StartedTheme = StartedTheme.valueOf(sharedPreferences?.getString(key, StartedTheme.LIGHT.name) ?: StartedTheme.LIGHT.name)
            _themeState.value = settingTheme
        }
    }

    override fun onCleared() {
        super.onCleared()
        sharePrefManager.unRegisterOnSharePrefChangeListener(this)
    }
}