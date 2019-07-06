package data.training.model

import java.util.concurrent.TimeUnit

data class TrainingConfigEntity(
    val rounds: Int = 1,
    val roundLengthMilli: Long = TimeUnit.MINUTES.toMillis(1),
    val breakLengthMilli: Long = TimeUnit.MINUTES.toMillis(1),
    val strikeDurationMilli: Long = 700,
    val strikeProbability: Float = 0.1f,
    val strikes: List<String>
)
