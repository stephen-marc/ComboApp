package libraries.core.timer

import android.os.CountDownTimer

abstract class Timer(
    var comboRefresh: Long = 50
) {
    private var countDownTimer: CountDownTimer? = null

    private var isPaused = false
    private var isCancelled = false
    private var resumeFromMillis: Long = 0

    open fun pause() {
        isPaused = true
        isCancelled = false
    }

    open fun resume() {
        isPaused = false
        isCancelled = false
        startTimer(resumeFromMillis)
    }

    open fun start() {
        isCancelled = false
        isPaused = false
        startTimer(nextCombo())
    }

    open fun stop() {
        isCancelled = false
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
                    isCancelled -> cancel()
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
    abstract fun nextCombo(): Long

    abstract fun onTickTimer(millisUntilFinished: Long)

    abstract fun onFinishTimer()
}