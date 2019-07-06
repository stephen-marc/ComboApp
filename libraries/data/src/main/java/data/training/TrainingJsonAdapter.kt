package data.training

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import data.training.model.TrainingConfigEntity
import data.training.model.TrainingEntity
import domain.Strike

fun createStrikeJsonAdapter(moshi: Moshi): JsonAdapter<List<Strike>> {
    val typeList =
        Types.newParameterizedType(
            List::class.java,
            Strike::class.java
        )
    return moshi.adapter(typeList)
}

fun createTrainingJsonAdapter(moshi: Moshi): JsonAdapter<List<TrainingEntity>> {
    val typeList =
        Types.newParameterizedType(
            List::class.java,
            TrainingEntity::class.java,
            TrainingConfigEntity::class.java
        )
    return moshi.adapter(typeList)
}
