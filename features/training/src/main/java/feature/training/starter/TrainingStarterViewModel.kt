package feature.training.starter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import libraries.core.util.LiveEvent
import libraries.core.util.triggerEvent

class TrainingStarterViewModel : ViewModel() {

    private val _navigationEvent = MutableLiveData<LiveEvent<NavDirections>>()
    val navigationEvent: LiveData<LiveEvent<NavDirections>>
        get() = _navigationEvent


    fun onStartTrainingClicked() {
        _navigationEvent.triggerEvent(TrainingStarterFragmentDirections.actionTrainingStarterToTrainingExercise())
    }

}
