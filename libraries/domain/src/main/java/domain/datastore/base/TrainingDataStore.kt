package domain.datastore.base

import domain.Training
import io.reactivex.Flowable

interface TrainingDataStore {
    fun getTrainingsOnce(): Flowable<List<Training>>
}
