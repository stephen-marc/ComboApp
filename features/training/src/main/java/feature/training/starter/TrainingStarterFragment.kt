package feature.training.starter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.jakewharton.rxbinding3.view.clicks
import feature.training.R
import feature.training.databinding.FragmentTrainingStarterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class TrainingStarterFragment : Fragment() {

    lateinit var binding: FragmentTrainingStarterBinding
    val args: TrainingStarterFragmentArgs by navArgs()
    private val viewModel: TrainingStarterViewModel by viewModel {
        parametersOf(args.trainingId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_training_starter,
                container,
                false
            )
        bindViewModel()
        bindListener()
        return binding.root
    }

    @SuppressLint("CheckResult")
    private fun bindListener() {
        binding.startTrainingButton.clicks().subscribe { viewModel.onStartTrainingClicked() }
    }

    private fun bindViewModel() {
        viewModel.navigationEvent.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { direction ->
                navigate(direction)
            }
        })

        viewModel.training.observe(viewLifecycleOwner, Observer { training ->
            binding.training = training
        })
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}
