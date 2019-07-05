package libraries.core.timer

import android.os.CountDownTimer

abstract class Timer(
    var comboRefresh: Long = 50
) {
    private var countDownTimer: CountDownTimer? = null

    private var isPaused = false
    private var resumeFromMillis: Long = 0

    open fun pause() {
        isPaused = true
    }

    open fun resume() {
        isPaused = false
        startTimer(resumeFromMillis)
        resumeFromMillis = 0
    }

    open fun start() {
        isPaused = false
        startTimer(next())
    }

    open fun stop() {
        isPaused = false
        countDownTimer?.cancel()
    }

    private fun startTimer(milli: Long) {
        countDownTimer = object : CountDownTimer(milli, comboRefresh) {
            override fun onTick(millisUntilFinished: Long) {
                when {
                    isPaused -> {
                        resumeFromMillis = millisUntilFinished
                        cancel()
                    }
                    else -> onTickTimer(millisUntilFinished)
                }
            }

            override fun onFinish() {
                onFinishTimer()
            }

        }.start()
    }

    /**
     * returns next combo in ms
     */
    abstract fun next(): Long

    abstract fun onTickTimer(millisUntilFinished: Long)

    abstract fun onFinishTimer()
}