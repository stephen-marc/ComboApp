package de.combo.app.selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import domain.entities.Training
import domain.usecase.GetTrainingsOnceUsecase

class TrainingSelectionViewModel(
    val getTrainingsOnceUsecase: GetTrainingsOnceUsecase
) : ViewModel() {

    private val _trainings = MutableLiveData<List<Training>>()
    val trainings: LiveData<List<Training>>
        get() = _trainings

}
