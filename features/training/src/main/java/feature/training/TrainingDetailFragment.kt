package feature.training

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import feature.training.databinding.FragmentTrainingDetailBinding
import feature.training.databinding.FragmentTrainingStarterBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingDetailFragment : Fragment() {

    lateinit var binding: FragmentTrainingStarterBinding
    private val viewModel: TrainingDetailViewModel by viewModel()

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
        return binding.root
    }

    private fun bindViewModel() {

    }
}
