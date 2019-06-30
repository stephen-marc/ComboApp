package de.combo.app

import App
import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ComboApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@ComboApp)
            modules(App.getModules())
        }
    }
}
