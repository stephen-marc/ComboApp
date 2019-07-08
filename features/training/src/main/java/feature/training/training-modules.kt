package feature.training

import feature.training.exercise.TrainingExerciseViewModel
import feature.training.starter.TrainingStarterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object Training {
    fun getModules(): List<Module> = listOf(viewModels)
}

val viewModels = module {
    viewModel { (trainingsId: String) ->
        TrainingStarterViewModel(
            trainingsId = trainingsId,
            getTrainingByIdOnceUsecase = get()
        )
    }

    viewModel {
        TrainingExerciseViewModel()
    }
}
