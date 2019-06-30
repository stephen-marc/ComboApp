package de.combo.app.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import de.combo.app.R
import de.combo.app.databinding.FragmentTrainingSelectionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingSelectionFragment : Fragment() {

    lateinit var binding: FragmentTrainingSelectionBinding
    private val viewModel: TrainingSelectionViewModel by viewModel()
    private lateinit var listController: CarouselController

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
        initCarousel()
        bindViewModel()
        return binding.root
    }

    private fun bindViewModel() {
        viewModel.trainings.observe(viewLifecycleOwner, Observer { trainings ->
            listController.setData(trainings)
        })
    }

    private fun initCarousel() {
        listController = CarouselController()
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

