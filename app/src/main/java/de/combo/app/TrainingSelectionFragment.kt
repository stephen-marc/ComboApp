package de.combo.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
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
        val listController = ListController()
        binding.recyclerView.setController(listController)
        listController.requestModelBuild()

    }
}

class ListController : EpoxyController() {
    override fun buildModels() {
        carousel {
            id("22")
            paddingDp(16)
            models(
                listOf(
                    TrainingCardBindingModel_().id(1),
                    TrainingCardBindingModel_().id(2),
                    TrainingCardBindingModel_().id(3),
                    TrainingCardBindingModel_().id(4)
                )
            )
        }
    }

}
