package domain

import domain.executor.JobExecutor
import domain.executor.ThreadExecutor
import domain.repository.TrainingDataRepository
import domain.repository.base.TrainingRepository
import domain.usecase.GetTrainingsOnceUsecase
import org.koin.core.module.Module
import org.koin.dsl.module

object Domain {
    fun getModules(): List<Module> = listOf(usecases, repository, executors)
}

val usecases = module {
    factory {
        GetTrainingsOnceUsecase(
            trainingRepository = get(),
            postExecutionThread = get(),
            threadExecutor = get()
        )
    }
}

val repository = module {
    single<TrainingRepository> {
        TrainingDataRepository(
            trainingDataStore = get()
        )
    }
}

val executors = module {
    single { JobExecutor() as ThreadExecutor }
}
