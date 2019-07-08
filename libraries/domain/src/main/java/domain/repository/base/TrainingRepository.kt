package domain.repository.base

import domain.Training
import io.reactivex.Flowable
import io.reactivex.Single

interface TrainingRepository {
    fun getTrainingsOnce(): Flowable<List<Training>>
    fun getTrainingByIdOnce(trainingsId: String): Single<Training>
}
