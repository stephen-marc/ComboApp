package de.combo.app.selection

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import domain.Training
import domain.usecase.GetTrainingsOnceAndStreamUsecase
import libraries.core.util.LiveEvent
import libraries.core.util.triggerEvent
import timber.log.Timber.e

class TrainingSelectionViewModel(
    val getTrainingsOnceAndStreamUseCase: GetTrainingsOnceAndStreamUsecase
) : ViewModel() {

    //TODO: Map domain model into presenter model
    private val _trainings =
        LiveDataReactiveStreams.fromPublisher(getTrainingsOnceAndStreamUseCase().doOnError { e(it) })
    val trainings: LiveData<List<Training>>
        get() = _trainings

    private val _navigation = MutableLiveData<LiveEvent<NavDirections>>()
    val navigation: LiveData<LiveEvent<NavDirections>>
        get() = _navigation

    fun onTrainingClicked(id: String) {
        _navigation.triggerEvent(
            TrainingSelectionFragmentDirections.actionTrainingSelectionToTrainingGraph(
                id
            )
        )
    }
}
