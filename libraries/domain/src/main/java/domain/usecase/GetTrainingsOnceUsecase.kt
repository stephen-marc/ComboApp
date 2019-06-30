package domain.usecase

import domain.entities.Training
import domain.executor.PostExecutionThread
import domain.executor.ThreadExecutor
import io.reactivex.Single
import org.buffer.android.boilerplate.data.interactor.SingleUseCase

class GetTrainingsOnceUsecase(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : SingleUseCase<List<Training>, Long?>(
    threadExecutor,
    postExecutionThread
) {
    override fun buildUseCaseObservable(params: Long?): Single<List<Training>> {
        return Single.just(emptyList<Training>())
    }
}
