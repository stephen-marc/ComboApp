package de.combo.app

import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import libraries.core.epoxy.KotlinEpoxyHolder


@EpoxyModelClass(layout = R.layout.view_holder_training_card)
abstract class TrainingCardWithHolder : EpoxyModelWithHolder<TrainingCardHolder>() {

    override fun bind(trainingCardHolder: TrainingCardHolder) {

    }

}

class TrainingCardHolder : KotlinEpoxyHolder() {

}



