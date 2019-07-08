package domain.usecase

import model.TrainingClass
import model.combo.Combo
import model.combo.Strike

fun getTClasses(): MutableList<TrainingClass> {
    val strikes = getStrikes()

    val jab = strikes.single { strike -> strike.name.equals("Jab") }
    val cross = strikes.single { strike -> strike.name.equals("Cross") }

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
    classA.rounds = 2
    classA.breaksInMSec = 5000
    classA.roundsInMSec = 10000

    val classes: MutableList<TrainingClass> = ArrayList()
    classes.add(classA)
    classes.add(classB)
    classes.add(classC)
    classes.add(classD)

    return classes
}

fun getCombos(): MutableList<Combo> {
    val strikes = getStrikes()


    val jab = strikes.single { strike -> strike.name.equals("Jab") }
    val cross = strikes.single { strike -> strike.name.equals("Cross") }
    val hookLeft = strikes.single { strike -> strike.name.equals("Hook Left") }
    val hookRight = strikes.single { strike -> strike.name.equals("Hook Right") }
    val uppercut = strikes.single { strike -> strike.name.equals("Uppercut") }
    val bodyLeft = strikes.single { strike -> strike.name.equals("Body Left") }

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
