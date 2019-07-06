package data.training.mapper

import data.training.model.TrainingConfigEntity
import domain.Strike
import domain.TrainingConfig
import domain.mapper.EntityMapper

class TrainingConfigEntityMapper(
        private val strikeInventory: List<Strike>
) : EntityMapper<TrainingConfig, TrainingConfigEntity> {
    override fun mapToEntity(type: TrainingConfig): TrainingConfigEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun mapFromEntity(type: TrainingConfigEntity): TrainingConfig {
        return TrainingConfig(
                rounds = type.rounds,
                roundLengthMilli = type.roundLengthMilli,
                breakLengthMilli = type.breakLengthMilli,
                strikeDurationMilli = type.strikeDurationMilli,
                strikeProbability = type.strikeProbability,
                strikes = type.strikes.map { strikeEntity ->
                    strikeInventory.first { strike ->
                        strike.abbreviation == strikeEntity
                    }
                }
        )
    }

}
