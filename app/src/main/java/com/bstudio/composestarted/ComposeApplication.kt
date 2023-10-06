package com.bstudio.composestarted

import android.app.Application
import com.bstudio.composestarted.di.viewModelModule
import com.bstudio.data.di.localModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class ComposeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            //inject Android context
            androidContext(this@ComposeApplication)
            loadKoinModules(listOf(viewModelModule, localModule) )
        }
    }
}