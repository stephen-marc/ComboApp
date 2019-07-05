package domain.repository

import domain.datastore.base.TrainingDataStore
import domain.entities.Training
import domain.repository.base.TrainingRepository
import io.reactivex.Flowable

class TrainingDataRepository(
    val trainingDataStore: TrainingDataStore
) : TrainingRepository {
    override fun getTrainingsOnce(): Flowable<List<Training>> {
        return trainingDataStore.getTrainingsOnce()
    }

}
