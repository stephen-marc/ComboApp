package libraries.core.timer


import java.util.*
import model.TrainingClass

open class RoundTimer(
    comboRefresh: Long = 50,
    var trainingClass: TrainingClass
) : Timer(comboRefresh) {

    var queue: Queue<Pair<Status, Int>> = ArrayDeque()
    var status: Status = Status.STOP
        set(value) {
            field = value
            onStatusChange(value)
        }
    var lastStatus: Status = Status.STOP


    override fun next(): Long {
        var pair = queue.poll()
        status = pair.first
        return pair.second.toLong()
    }

    fun init() {
        queue.clear()
        queue.add(Pair(Status.START, 3000))
        for (i in 1 until trainingClass.rounds) {
            queue.add(Pair(Status.TRAIN, trainingClass.roundsInMSec))
            queue.add(Pair(Status.REST, trainingClass.breaksInMSec))
        }
        queue.add(Pair(Status.TRAIN, trainingClass.roundsInMSec))
        queue.add(Pair(Status.STOP, 0))

    }

    open fun onStatusChange(value: Status?) {
    }

    override fun onTickTimer(millisUntilFinished: Long) {
    }

    override fun onFinishTimer() {
        when (status) {
            Status.START, Status.TRAIN, Status.REST -> start()
        }
    }

    fun togglePauseResume() {
        if(status == Status.PAUSE) {
            resume()
        } else if(status != Status.STOP) {
            pause()
        }
    }

    override fun pause() {
        lastStatus = status
        status = Status.PAUSE
        super.pause()
    }

    override fun stop() {
        status = Status.STOP
        super.stop()
    }

    override fun resume() {
        status = lastStatus
        super.resume()
    }

}

enum class Status {
    START, TRAIN, STOP, PAUSE, REST
}
