package de.combo.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import de.combo.app.databinding.FragmentTrainingSelectionBinding

class TrainingSelectionFragment : Fragment() {

    lateinit var binding: FragmentTrainingSelectionBinding

    override fun onCreateView(inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
        binding =
                DataBindingUtil.inflate(inflater,
                        R.layout.fragment_training_selection,
                        container,
                        false)
        return binding.root
    }
}
