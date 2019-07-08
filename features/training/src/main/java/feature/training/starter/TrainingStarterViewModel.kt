package feature.training.starter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import domain.Training
import domain.usecase.GetTrainingByIdOnceUsecase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import libraries.core.util.LiveEvent
import libraries.core.util.triggerEvent
import timber.log.Timber.e

class TrainingStarterViewModel(
    val trainingsId: String,
    val getTrainingByIdOnceUsecase: GetTrainingByIdOnceUsecase
) : ViewModel() {

    private val _navigationEvent = MutableLiveData<LiveEvent<NavDirections>>()
    val navigationEvent: LiveData<LiveEvent<NavDirections>>
        get() = _navigationEvent

    private val _training = MutableLiveData<Training>()
    val training: LiveData<Training>
        get() = _training

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    init {
        getTrainingByIdOnceUsecase(
            GetTrainingByIdOnceUsecase.Parameter(trainingsId)
        ).subscribe({
            _training.value = it
        }, { e(it) }).addTo(compositeDisposable)
    }


    fun onStartTrainingClicked() {
        _navigationEvent.triggerEvent(TrainingStarterFragmentDirections.actionTrainingStarterToTrainingExercise())
    }

}
