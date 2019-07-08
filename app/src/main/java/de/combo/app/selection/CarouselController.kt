package de.combo.app.selection

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import de.combo.app.trainingCard
import domain.Training

typealias OnTrainingClickedListener = (View, String) -> Unit

class CarouselController(
    val onTrainingClicked: OnTrainingClickedListener
) : TypedEpoxyController<List<Training>>() {
    override fun buildModels(data: List<Training>) {
        data.forEach { training ->
            trainingCard {
                id(training.id)
                training(training)
                onTrainingClicked { model, _, view, _ ->
                    onTrainingClicked(view, model.training().id)
                }
            }
        }
    }
}
