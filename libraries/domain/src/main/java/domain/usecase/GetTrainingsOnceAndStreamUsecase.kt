package domain.usecase

import domain.Training
import domain.executor.PostExecutionThread
import domain.executor.ThreadExecutor
import domain.repository.base.TrainingRepository
import io.reactivex.Flowable
import org.buffer.android.boilerplate.data.interactor.FlowableUseCase

class GetTrainingsOnceAndStreamUsecase(
    private val trainingRepository: TrainingRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : FlowableUseCase<List<Training>, Long?>(
    threadExecutor,
    postExecutionThread
) {
    override fun buildUseCaseObservable(params: Long?): Flowable<List<Training>> {
        return trainingRepository.getTrainingsOnce()
    }
}
