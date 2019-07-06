package data.training

import com.squareup.moshi.JsonAdapter
import data.training.mapper.TrainingConfigEntityMapper
import data.training.mapper.TrainingEntityMapper
import data.training.model.TrainingEntity
import domain.Strike
import domain.Training
import domain.datastore.base.TrainingDataStore
import domain.provider.ResourceProvider
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.rxkotlin.Singles
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.AsyncSubject

const val ASSET_STRIKES_FILENAME = "strikes.json"
const val ASSET_TRAINING_FILENAME = "training.json"

class JSONTrainingDataStore(
        val strikeAdapter: JsonAdapter<List<Strike>>,
        val trainingAdapter: JsonAdapter<List<TrainingEntity>>,
        private val resourceProvider: ResourceProvider
) : TrainingDataStore {

    private var strikes: Observable<List<Strike>> =
            Observable.fromCallable {
                parseJsonStrikes()
            }.subscribeOn(Schedulers.io())
                .subscribeWith(AsyncSubject.create())

    private var training: Observable<List<TrainingEntity>> =
            Observable.fromCallable {
                parseJsonTrainings()
            }.subscribeOn(Schedulers.io())
                .subscribeWith(AsyncSubject.create())

    override fun getTrainingsOnce(): Flowable<List<Training>> {
        return Singles.zip(training.singleOrError(),
                strikes.singleOrError()) { trainings, strikes ->
            val trainingEntityMapper =
                    TrainingEntityMapper(TrainingConfigEntityMapper(strikes))
            trainings.map { trainingEntity ->
                trainingEntityMapper.mapFromEntity(trainingEntity)
            }
        }.toFlowable()
    }

    private fun parseJsonStrikes(): List<Strike> {
        val jsonString =
                resourceProvider.readAssetIntoString(ASSET_STRIKES_FILENAME)
        return strikeAdapter.fromJson(jsonString) ?: emptyList()
    }

    private fun parseJsonTrainings(): List<TrainingEntity> {
        val jsonString =
                resourceProvider.readAssetIntoString(ASSET_TRAINING_FILENAME)
        return trainingAdapter.fromJson(jsonString) ?: emptyList()
    }
}
