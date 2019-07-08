package feature.training.exercise

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jakewharton.rxbinding3.view.clicks
import domain.usecase.getCombos
import domain.usecase.getTClasses
import feature.training.R
import feature.training.databinding.FragmentTrainingExerciseBinding
import feature.training.starter.TrainingStarterViewModel
import libraries.core.timer.ComboTimer
import libraries.core.timer.RoundTimer
import libraries.core.timer.Status
import model.TrainingClass
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Queue

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
        config()
        return binding.root
    }


    /**
     * Ich pack das einfach mal hier rein um meine sachen zu testen
     */

    @SuppressLint("CheckResult")
    private fun config() {
        var cl = getTClasses()
        var combo = getCombos()

        var time_label = binding.time
        var status_label = binding.status
        var round_label = binding.round
        var combo_label = binding.combo

        var comboTimer: ComboTimer? = null

        var timer = object : RoundTimer(trainingClass = cl[0]) {

            override fun onTickTimer(millisUntilFinished: Long) {
                super.onTickTimer(millisUntilFinished)
                time_label.text = convertToString(millisUntilFinished)
            }

            override fun onStatusChange(value: Status?) {
                super.onStatusChange(value)
                if (value == Status.TRAIN) {
                    comboTimer?.start()
                }


                status_label.text = value?.name
                round_label.text = convertRoundToString(this.trainingClass, this.queue)
            }
        }

        comboTimer = object : ComboTimer(trainingClass = cl[0], combo = combo[0]) {
            override fun onComboChange(value: String) {
                super.onComboChange(value)
                combo_label.text = value
            }

            override fun next(): Long {
                when (timer.status) {
                    libraries.core.timer.Status.TRAIN -> return super.next()
                }
                stop()
                return 0
            }
        }

        var button_pause_resume = binding.pause
        button_pause_resume.setOnClickListener {
            if (button_pause_resume.text == "Pause") {
                button_pause_resume.text = "Resume"
            } else {
                button_pause_resume.text = "Pause"
            }
            timer.togglePauseResume()
            comboTimer.togglePauseResume()
        }

        binding.again.clicks().subscribe {
            button_pause_resume.text = "Pause"
            timer.init()
            timer.start()
        }
    }


    private fun convertToString(millis: Long): String {
        val minutes = (millis / 1000 / 60).toString().padStart(2, '0')
        val seconds = (millis / 1000 % 60).toString().padStart(2, '0')
        return "${minutes}:${seconds}"
    }

    private fun convertRoundToString(
        trainingClass: TrainingClass,
        queue: Queue<Pair<Status, Int>>
    ): CharSequence? {
        var rounds = trainingClass.rounds
        var roundsLeft = rounds - queue.count { pair -> pair.first.equals(Status.TRAIN) }
        return "${roundsLeft}/${rounds}"
    }

}
