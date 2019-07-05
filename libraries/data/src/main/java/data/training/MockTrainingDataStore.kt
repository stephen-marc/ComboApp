package data.training

import domain.datastore.base.TrainingDataStore
import domain.entities.Training
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
                        imageName = "test.png"
                    ),
                    Training(
                        id = 2,
                        title = "Training 2",
                        description = "Lorem Ipsum",
                        imageName = "test.png"
                    ),
                    Training(
                        id = 3,
                        title = "Training 3",
                        description = "Lorem Ipsum",
                        imageName = "test.png"
                    ),
                    Training(
                        id = 4,
                        title = "Training 4",
                        description = "Lorem Ipsum",
                        imageName = "test.png"
                    )
                )
            )
        }
    }

}
