package domain

import domain.executor.JobExecutor
import domain.executor.ThreadExecutor
import domain.usecase.GetTrainingsOnceUsecase
import org.koin.core.module.Module
import org.koin.dsl.module

object Domain {
    fun getModules(): List<Module> = listOf(usecases, executors)
}

val usecases = module {
    factory {
        GetTrainingsOnceUsecase(
            postExecutionThread = get(),
            threadExecutor = get()
        )
    }
}

val executors = module {
    single { JobExecutor() as ThreadExecutor }
}
