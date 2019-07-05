package libraries.core.timer

import model.TrainingClass
import model.combo.Combo
import model.combo.Strike

open class ComboTimer(
    comboRefresh: Long = 50,
    var trainingClass: TrainingClass,
    var combo: Combo
) : Timer(comboRefresh) {

    enum class Status {
        START, STOP
    }

    var status: Status = Status.STOP
        set(value) {
            onStatusChange(value)
            field = value
        }

    override fun next(): Long {
        var idx = chooseOnWeight(combo.strikes, combo.weights) + 1
        onComboChange(idx.toString())
        return trainingClass.mSecPerStrike.toLong() * idx
    }

    override fun onTickTimer(millisUntilFinished: Long) {
    }

    override fun onFinishTimer() {
        if (status != Status.STOP) {
            start()
        }
    }

    fun togglePauseResume() {
        if (status == Status.START) {
            stop()
        } else {
            start()
        }
    }

    override fun stop() {
        status = Status.STOP
        super.stop()
    }

    override fun start() {
        status = Status.START
        super.start()
    }

    override fun pause() {
        this.stop()
    }

    override fun resume() {
        this.start()
    }

    open fun onStatusChange(value: Status) {
    }

    open fun onComboChange(value: String) {

    }

    private fun chooseOnWeight(strikes: List<Strike>, weights: List<Int>): Int {
        val r = Math.random() * weights.sum()
        var countWeight = 0.0
        for (i in 0..strikes.size) {
            countWeight += weights[i]
            if (countWeight >= r)
                return i
        }
        throw RuntimeException("Should never be shown.")
    }
}