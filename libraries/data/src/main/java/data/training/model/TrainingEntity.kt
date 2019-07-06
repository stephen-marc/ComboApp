package data.training.model

data class TrainingEntity(
    val id: Long,
    val title: String,
    val description: String,
    val imageName: String,
    val config: TrainingConfigEntity
)
