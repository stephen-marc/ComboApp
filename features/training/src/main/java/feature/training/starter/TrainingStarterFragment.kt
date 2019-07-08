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
import com.jakewharton.rxbinding3.view.clicks
import feature.training.R
import feature.training.databinding.FragmentTrainingStarterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingStarterFragment : Fragment() {

    lateinit var binding: FragmentTrainingStarterBinding
    private val viewModel: TrainingStarterViewModel by viewModel()

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
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}
