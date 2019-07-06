package domain

data class Training(
    val id: Long,
    val title: String,
    val description: String,
    val imageName: String,
    val config: TrainingConfig
)
