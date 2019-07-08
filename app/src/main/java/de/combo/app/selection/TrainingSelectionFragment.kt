package de.combo.app.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import de.combo.app.R
import de.combo.app.databinding.FragmentTrainingSelectionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingSelectionFragment : Fragment() {

    lateinit var binding: FragmentTrainingSelectionBinding
    private val viewModel: TrainingSelectionViewModel by viewModel()
    private lateinit var carouselController: CarouselController

    val viewList = mutableListOf<Pair<View, String>>()

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
            carouselController.setData(trainings)
        })

        viewModel.navigation.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let { direction ->
                navigateTo(direction)
            }
        })
    }

    private fun navigateTo(direction: NavDirections) {
        val extras = FragmentNavigatorExtras(*viewList.map { it }.toTypedArray())
        findNavController().navigate(direction, extras)
    }

    private fun initCarousel() {
        carouselController = CarouselController(this::onTrainingSelected)
        binding.recyclerView.apply {
            setController(carouselController)
            setPaddingDp(16)
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
        }
    }

    private fun onTrainingSelected(view: View, id: String) {
        viewList.clear()
        view.findViewById<TextView>(R.id.title)?.apply {
            transitionName = "transition_title"
            viewList.add(Pair(this, "transition_title"))
        }
        view.findViewById<ImageView>(R.id.image)?.apply {
            transitionName = "transition_image"
            viewList.add(Pair(this, "transition_image"))
        }
        view.findViewById<TextView>(R.id.description)?.apply {
            transitionName = "transition_description"
            viewList.add(Pair(this, "transition_description"))
        }
        viewModel.onTrainingClicked(id)
    }
}


