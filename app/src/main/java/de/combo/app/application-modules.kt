package de.combo.app

import de.combo.app.thread.UiThread
import domain.executor.PostExecutionThread
import org.koin.core.module.Module
import org.koin.dsl.module

object Infrastructure {
    fun getModules(): List<Module> =
        listOf(applicationModule)
}

val applicationModule = module {
    single { UiThread() as PostExecutionThread }
}
