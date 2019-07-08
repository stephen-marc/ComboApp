package domain.repository

import domain.Training
import domain.datastore.base.TrainingDataStore
import domain.repository.base.TrainingRepository
import io.reactivex.Flowable
import io.reactivex.Single

class TrainingDataRepository(
    val trainingDataStore: TrainingDataStore
) : TrainingRepository {
    override fun getTrainingByIdOnce(trainingsId: String): Single<Training> {
        return trainingDataStore.getTrainingsOnceAndStream().map { list ->
            list.first { it.id == trainingsId }
        }.firstOrError()
    }

    override fun getTrainingsOnce(): Flowable<List<Training>> {
        return trainingDataStore.getTrainingsOnceAndStream()
    }

}
