package org.buffer.android.boilerplate.data.interactor

import domain.executor.PostExecutionThread
import domain.executor.ThreadExecutor
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Abstract class for a UseCase that returns an instance of a [Single].
 */
abstract class FlowableUseCase<T, in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    /**
     * Builds a [Flowable] which will be used when the current [FlowableUseCase] is executed.
     */
    protected abstract fun buildUseCaseObservable(params: Params? = null): Flowable<T>

    /**
     * Builds a [Single] which will be used when the current [FlowableUseCase] is executed.
     */
    open fun getObservable(params: Params? = null) =
        buildUseCaseObservable(params)

    /**
     * Executes the current use case.
     */
    open fun execute(params: Params? = null): Flowable<T> {
        return this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }
}
