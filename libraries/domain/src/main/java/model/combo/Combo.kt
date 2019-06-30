package model.combo

data class Combo(
    val name: String?,
    val description: String?,
    val strikes: List<Strike> = ArrayList(),
    var weights: List<Int> = ArrayList()
)