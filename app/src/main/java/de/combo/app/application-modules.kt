package de.combo.app

import de.combo.app.thread.UiThread
import de.combo.app.thread.provider.AndroidResourceProvider
import domain.executor.PostExecutionThread
import domain.provider.ResourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object Infrastructure {
    fun getModules(): List<Module> =
        listOf(applicationModule)
}

val applicationModule = module {
    single { UiThread() } bind PostExecutionThread::class

    single { AndroidResourceProvider(androidContext()) } bind ResourceProvider::class
}
