package domain.repository.base

import domain.Training
import io.reactivex.Flowable

interface TrainingRepository {
    fun getTrainingsOnce(): Flowable<List<Training>>
}
