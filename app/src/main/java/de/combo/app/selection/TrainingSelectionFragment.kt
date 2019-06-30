package de.combo.app.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import de.combo.app.R
import de.combo.app.databinding.FragmentTrainingSelectionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingSelectionFragment : Fragment() {

    lateinit var binding: FragmentTrainingSelectionBinding
    val viewModel: TrainingSelectionViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_training_selection,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCarousel()
    }

    private fun initCarousel() {
        val listController = ListController()
        binding.recyclerView.apply {
            setController(listController)
            setPaddingDp(16)
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }
}

