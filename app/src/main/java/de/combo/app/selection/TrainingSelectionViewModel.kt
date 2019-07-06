package de.combo.app.selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import domain.Training
import domain.usecase.GetTrainingsOnceUsecase

class TrainingSelectionViewModel(
    val getTrainingsOnceUseCase: GetTrainingsOnceUsecase
) : ViewModel() {

    //TODO: Map domain model into presenter model
    private val _trainings = LiveDataReactiveStreams.fromPublisher(getTrainingsOnceUseCase())
    val trainings: LiveData<List<Training>>
        get() = _trainings
}
