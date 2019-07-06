package data

import com.squareup.moshi.Moshi
import data.training.JSONTrainingDataStore
import data.training.createStrikeJsonAdapter
import data.training.createTrainingJsonAdapter
import domain.datastore.base.TrainingDataStore
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Data {
    fun getModules(): List<Module> = listOf(datastores, adapter)
}

val datastores = module {
    single<TrainingDataStore> {
        JSONTrainingDataStore(
            strikeAdapter = get(named("StrikeJsonAdapter")),
            trainingAdapter = get(named("TrainingJsonAdapter")),
            resourceProvider = get()
        )
    }
}

val adapter = module {
    single(qualifier = named("StrikeJsonAdapter")) {
        createStrikeJsonAdapter(moshi = get())
    }

    single(qualifier = named("TrainingJsonAdapter")) {
        createTrainingJsonAdapter(moshi = get())
    }

    single { Moshi.Builder().build() }
}


