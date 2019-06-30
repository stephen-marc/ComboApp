package libraries.core.timer


import java.util.*
import model.TrainingClass

class RoundTimer(
    comboRefresh: Long,
    var trainingClass: TrainingClass
) : Timer(comboRefresh) {

    var queue: Queue<Pair<Status, Int>> = ArrayDeque()
    var cStatus: Status? = null
        set(value) {
            onStatusChange(value)
        }

    override fun nextCombo(): Long {
        var pair = queue.poll()
        cStatus = pair.first
        return pair.second.toLong()
    }

    fun init() {
        queue.add(Pair(Status.START, 3000))
        for (i in 1..trainingClass.rounds) {
            queue.add(Pair(Status.TRAIN, trainingClass.roundsInMSec))
            queue.add(Pair(Status.REST, trainingClass.breaksInMSec))
        }
        // remove last rest
        queue.poll()
    }

    fun onStatusChange(value: Status?) {
        println(value)
    }

    override fun onTickTimer(millisUntilFinished: Long) {
        println(millisUntilFinished)
    }

    override fun onFinishTimer() {
        println("Finish")
    }

    override fun pause() {
        cStatus = Status.PAUSE
        super.pause()
    }

    override fun stop() {
        cStatus = Status.STOP
        super.stop()
    }
}

enum class Status {
    START, TRAIN, STOP, PAUSE, REST
}
