package de.combo.app.selection

import com.airbnb.epoxy.TypedEpoxyController
import de.combo.app.trainingCard
import domain.Training

typealias OnTrainingClickedListener = () -> Unit

class CarouselController(
    val onTrainingClicked: OnTrainingClickedListener
) : TypedEpoxyController<List<Training>>() {
    override fun buildModels(data: List<Training>) {
        data.forEach { training ->
            trainingCard {
                id(training.id)
                training(training)
                onTrainingClicked { _, _, _, _ ->
                    onTrainingClicked()
                }
            }
        }
    }
}
