package domain.usecase

import domain.Training
import domain.executor.PostExecutionThread
import domain.executor.ThreadExecutor
import domain.repository.base.TrainingRepository
import io.reactivex.Single
import org.buffer.android.boilerplate.data.interactor.SingleUseCase

class GetTrainingByIdOnceUsecase(
    private val trainingRepository: TrainingRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<Training, GetTrainingByIdOnceUsecase.Parameter>(
    threadExecutor,
    postExecutionThread
) {
    override fun buildUseCaseObservable(params: Parameter?): Single<Training> {
        checkNotNull(params)
        return trainingRepository.getTrainingByIdOnce(params.trainingsId)
    }


    data class Parameter(
        val trainingsId: String
    )
}
