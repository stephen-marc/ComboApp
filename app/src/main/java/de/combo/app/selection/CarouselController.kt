package de.combo.app.selection

import com.airbnb.epoxy.TypedEpoxyController
import de.combo.app.trainingCard
import domain.Training

class CarouselController : TypedEpoxyController<List<Training>>() {
    override fun buildModels(data: List<Training>) {
        data.forEach { training ->
            trainingCard {
                id(training.id)
                training(training)
            }
        }
    }
}
