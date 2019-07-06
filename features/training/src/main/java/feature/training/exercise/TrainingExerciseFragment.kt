package feature.training.exercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import feature.training.R
import feature.training.databinding.FragmentTrainingExerciseBinding
import feature.training.starter.TrainingStarterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingExerciseFragment : Fragment() {

    lateinit var binding: FragmentTrainingExerciseBinding
    private val viewModel: TrainingStarterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_training_exercise,
                container,
                false
            )
        bindViewModel()
        return binding.root
    }

    private fun bindViewModel() {

    }
}
