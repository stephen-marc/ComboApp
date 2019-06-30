package domain.datastore.base

import domain.entities.Training
import io.reactivex.Flowable

interface TrainingDataStore {
    fun getTrainingsOnce(): Flowable<List<Training>>
}
