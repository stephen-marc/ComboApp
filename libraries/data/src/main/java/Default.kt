import android.annotation.TargetApi
import android.os.Build
import model.TrainingClass
import model.combo.Combo
import model.combo.Strike

@TargetApi(Build.VERSION_CODES.N)
fun getTClasses(): MutableList<TrainingClass> {
    val strikes = getStrikes()

    val jab = strikes.stream().filter { t -> t.name?.equals("Jab")!! }.findFirst().orElse(null)
    val cross = strikes.stream().filter { t -> t.name?.equals("Cross")!! }.findFirst().orElse(null)

    var strikeList = listOf(jab, cross)

    var weights = generateSequence { strikeList.size }.take(4).toMutableList()
    val classD = TrainingClass(
        "D-Class",
        aStrikes = strikeList,
        aStrikeWeights = weights
    )
    classD.rounds = 3
    classD.roundsInMSec = 20000
    classD.breaksInMSec = 5000
    classD.aStrikesProb = 0.9

    val classC = TrainingClass("C-Class")
    classC.rounds = 5
    classC.roundsInMSec = 120000

    val classB = TrainingClass("B-Class")
    classB.rounds = 5
    classB.roundsInMSec = 180000

    val classA = TrainingClass("A-Class")
    classA.rounds = 7
    classA.roundsInMSec = 180000

    val classes: MutableList<TrainingClass> = ArrayList()
    classes.add(classA)
    classes.add(classB)
    classes.add(classC)
    classes.add(classD)

    return classes
}

@TargetApi(Build.VERSION_CODES.N)
fun getCombos(): MutableList<Combo> {
    val strikes = getStrikes()

    val jab = strikes.stream().filter { t -> t.name?.equals("Jab")!! }.findFirst().orElse(null)
    val cross = strikes.stream().filter { t -> t.name?.equals("Cross")!! }.findFirst().orElse(null)
    val hookLeft = strikes.stream().filter { t -> t.name?.equals("Hook Left")!! }.findFirst().orElse(null)
    val hookRight = strikes.stream().filter { t -> t.name?.equals("Hook Right")!! }.findFirst().orElse(null)
    val uppercut = strikes.stream().filter { t -> t.name?.equals("Uppercut")!! }.findFirst().orElse(null)
    val bodyLeft = strikes.stream().filter { t -> t.name?.equals("Body Left")!! }.findFirst().orElse(null)

    var combo1Strikes = listOf(jab, cross, hookLeft, hookRight, uppercut)
    val combo1 = Combo("Combo1", "Default", combo1Strikes, MutableList(combo1Strikes.size) { 1 })

    combo1Strikes = listOf(jab, cross, hookLeft, bodyLeft)
    val combo2 = Combo("Combo1", "Default", combo1Strikes, MutableList(combo1Strikes.size) { 1 })

    val combos: MutableList<Combo> = ArrayList()
    combos.add(combo1)
    combos.add(combo2)

    return combos
}

private fun getStrikes(): MutableList<Strike> {
    val jab = Strike("Jab", "J")
    val cross = Strike("Cross", "C")
    val hookLeft = Strike("Hook Left", "HL")
    val hookRight = Strike("Hook Right", "HR")
    val bodyLeft = Strike("Body Left", "BL")
    val bodyRight = Strike("Body Right", "BR")
    val uppercut = Strike("Uppercut", "U")

    val lowKickLeft = Strike("Lowkick Left", "LL")
    val lowKickRight = Strike("Lowkick Right", "LR")
    val middleKickLeft = Strike("Middlekick Left", "ML")
    val middleKickRight = Strike("Middlekick Right", "MR")
    val highKickLeft = Strike("Highkick Left", "HIL")
    val highKickRight = Strike("Highkick Right", "HIR")

    val strikes: MutableList<Strike> = ArrayList()
    strikes.add(jab)
    strikes.add(cross)
    strikes.add(hookLeft)
    strikes.add(hookRight)
    strikes.add(bodyLeft)
    strikes.add(bodyRight)
    strikes.add(uppercut)
    strikes.add(lowKickLeft)
    strikes.add(lowKickRight)
    strikes.add(middleKickLeft)
    strikes.add(middleKickRight)
    strikes.add(highKickLeft)
    strikes.add(highKickRight)

    return strikes
}