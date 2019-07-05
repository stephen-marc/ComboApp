package data

import data.training.MockTrainingDataStore
import domain.datastore.base.TrainingDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

object Data {
    fun getModules(): List<Module> = listOf(datastores)
}

val datastores = module {
    single<TrainingDataStore> {
        MockTrainingDataStore()
    }
}
