package org.buffer.android.boilerplate.data.interactor

import domain.executor.PostExecutionThread
import domain.executor.ThreadExecutor
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Abstract class for a UseCase that returns an instance of a [Single].
 */
abstract class MaybeUseCase<T, in Params> constructor(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) {

    /**
     * Builds a [Single] which will be used when the current [SingleUseCase] is executed.
     */
    protected abstract fun buildUseCaseObservable(params: Params? = null): Maybe<T>

    /**
     * Executes the current use case.
     */
    open fun execute(params: Params? = null): Maybe<T> {
        return this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler)
    }
}
