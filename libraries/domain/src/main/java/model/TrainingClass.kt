package model

import model.combo.Strike

data class TrainingClass (
    val name: String,
    var rounds: Int = 1,
    var roundsInMSec: Int = 60000,
    var breaksInMSec: Int = 60000,
    var mSecPerStrike: Int = 700,
    var aStrikesProb: Double = 0.1,
    val aStrikes: List<Strike> = ArrayList(),
    var aStrikeWeights: List<Int> = ArrayList()
)