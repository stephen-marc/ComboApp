package data.training.mapper

import data.training.model.TrainingEntity
import domain.Training
import domain.mapper.EntityMapper

class TrainingEntityMapper(
        val trainingConfigEntityMapper: TrainingConfigEntityMapper
) : EntityMapper<Training, TrainingEntity> {
    override fun mapToEntity(type: Training): TrainingEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapFromEntity(type: TrainingEntity): Training {
        return Training(
                id = type.id,
                title = type.title,
                description = type.description,
                imageName = type.imageName,
                config = trainingConfigEntityMapper.mapFromEntity(type.configuration)
        )

    }

}
