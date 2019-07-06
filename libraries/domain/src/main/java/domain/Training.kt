package domain

data class Training(
    val id: String,
    val title: String,
    val description: String,
    val imageName: String,
    val config: TrainingConfig
)
