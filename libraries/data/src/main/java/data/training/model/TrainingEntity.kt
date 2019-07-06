package data.training.model

data class TrainingEntity(
    val id: String,
    val title: String,
    val description: String,
    val imageName: String,
    val configuration: TrainingConfigEntity
)
