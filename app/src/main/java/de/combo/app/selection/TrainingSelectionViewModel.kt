package de.combo.app.selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import domain.Training
import domain.usecase.GetTrainingsOnceUsecase

class TrainingSelectionViewModel(
    val getTrainingsOnceUsecase: GetTrainingsOnceUsecase
) : ViewModel() {

    private val _trainings = LiveDataReactiveStreams.fromPublisher(getTrainingsOnceUsecase())
    val trainings: LiveData<List<Training>>
        get() = _trainings
}
