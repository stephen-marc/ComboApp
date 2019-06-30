package de.combo.app

import App
import android.app.Application
import domain.Domain
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class ComboApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            TODO("Add crashreporting for release builds")
        }
    }

    private fun initKoin() {
        Timber.d("Init koin")
        startKoin {
            androidContext(this@ComboApp)
            modules(App.getModules())
            modules(Infrastructure.getModules())
            modules(Domain.getModules())
        }
    }
}
