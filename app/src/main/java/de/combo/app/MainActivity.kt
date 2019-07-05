package de.combo.app

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import getCombos
import getTClasses
import libraries.core.timer.ComboTimer
import libraries.core.timer.RoundTimer
import libraries.core.timer.Status
import model.TrainingClass
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        setContentView(R.layout.activity_main_test)
//        config()
    }

    /**
     * Ich pack das einfach mal hier rein um meine sachen zu testen
     */
    private fun config() {
        var cl = getTClasses()
        var combo = getCombos()

        var time_label = findViewById<TextView>(R.id.time)
        var status_label = findViewById<TextView>(R.id.status)
        var round_label = findViewById<TextView>(R.id.round)
        var combo_label = findViewById<TextView>(R.id.combo)

        var comboTimer: ComboTimer? = null

        var timer = object : RoundTimer(trainingClass = cl[0]) {

            override fun onTickTimer(millisUntilFinished: Long) {
                super.onTickTimer(millisUntilFinished)
                time_label.text = convertToString(millisUntilFinished)
            }
            override fun onStatusChange(value: Status?) {
                super.onStatusChange(value)
                if(value == Status.TRAIN) {
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

        var button_pause_resume = findViewById<Button>(R.id.pause)
        button_pause_resume.setOnClickListener {
            if (button_pause_resume.text == "Pause") {
                button_pause_resume.text = "Resume"
            } else {
                button_pause_resume.text = "Pause"
            }
            timer.togglePauseResume()
            comboTimer.togglePauseResume()
        }

        findViewById<Button>(R.id.again).setOnClickListener {
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

    private fun convertRoundToString(trainingClass: TrainingClass, queue: Queue<Pair<Status, Int>>): CharSequence? {
        var rounds = trainingClass.rounds
        var roundsLeft = rounds - queue.count { pair -> pair.first.equals(Status.TRAIN) }
        return "${roundsLeft}/${rounds}"
    }


}
