package data.training

import domain.Strike
import domain.Training
import domain.TrainingConfig
import domain.datastore.base.TrainingDataStore
import io.reactivex.Flowable

class MockTrainingDataStore : TrainingDataStore {
    override fun getTrainingsOnce(): Flowable<List<Training>> {
        return Flowable.defer {
            Flowable.just(
                listOf(
                    Training(
                        id = 1,
                        title = "Training 1",
                        description = "Lorem Ipsum",
                        imageName = "test.png",
                        config = TrainingConfig(
                            rounds = 1,
                            roundLengthMilli = 60000,
                            breakLengthMilli = 60000,
                            strikeDurationMilli = 700,
                            strikeProbability = 0.1f,
                            strikes = listOf(Strike("Schelle", "S"))
                        )
                    ),
                    Training(
                        id = 2,
                        title = "Training 2",
                        description = "Lorem Ipsum",
                        imageName = "test.png",
                        config = TrainingConfig(
                            rounds = 1,
                            roundLengthMilli = 60000,
                            breakLengthMilli = 60000,
                            strikeDurationMilli = 700,
                            strikeProbability = 0.1f,
                            strikes = listOf(Strike("Schelle", "S"))
                        )
                    ),
                    Training(
                        id = 3,
                        title = "Training 2",
                        description = "Lorem Ipsum",
                        imageName = "test.png",
                        config = TrainingConfig(
                            rounds = 1,
                            roundLengthMilli = 60000,
                            breakLengthMilli = 60000,
                            strikeDurationMilli = 700,
                            strikeProbability = 0.1f,
                            strikes = listOf(Strike("Schelle", "S"))
                        )
                    )
                )
            )
        }
    }
}
