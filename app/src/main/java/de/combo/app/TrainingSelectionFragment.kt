import android.view.ViewGroup
package de.combo.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyController
import de.combo.app.databinding.FragmentTrainingSelectionBinding

class TrainingSelectionFragment : Fragment() {

    lateinit var binding: FragmentTrainingSelectionBinding

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
            setControllerAndBuildModels(listController)
            setPaddingDp(16)
            layoutManager =
                    LinearLayoutManager(requireContext(),
                            LinearLayoutManager.HORIZONTAL,
                             false)
        }
        listController.requestModelBuild()
    }
}

class ListController : EpoxyController() {
    override fun buildModels() {
        trainingCard {
            id(1)
        }

        trainingCard {
            id(2)
        }

        trainingCard {
            id(3)
        }

        trainingCard {
            id(4)
        }
    }

}
