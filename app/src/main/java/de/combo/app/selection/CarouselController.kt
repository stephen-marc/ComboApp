package de.combo.app.selection

import com.airbnb.epoxy.TypedEpoxyController
import de.combo.app.trainingCard
import domain.entities.Training

class ListController : TypedEpoxyController<List<Training>>() {
    override fun buildModels(data: List<Training>) {
        data.forEach { training ->
            trainingCard {
                id(training.id)
            }
        }
    }

}
