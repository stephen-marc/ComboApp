package domain

import domain.executor.JobExecutor
import domain.executor.ThreadExecutor
import domain.repository.TrainingDataRepository
import domain.repository.base.TrainingRepository
import domain.usecase.GetTrainingByIdOnceUsecase
import domain.usecase.GetTrainingsOnceAndStreamUsecase
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object Domain {
    fun getModules(): List<Module> = listOf(usecases, repository, executors)
}

val usecases = module {
    factory {
        GetTrainingsOnceAndStreamUsecase(
            trainingRepository = get(),
            postExecutionThread = get(),
            threadExecutor = get()
        )
    }

    factory {
        GetTrainingByIdOnceUsecase(
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
    single { JobExecutor() } bind ThreadExecutor::class
}
