import de.combo.app.selection.TrainingSelectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object App {
    fun getModules(): List<Module> = listOf(viewModels)
}

val viewModels = module {
    viewModel {
        TrainingSelectionViewModel(
            getTrainingsOnceUseCase = get()
        )
    }
}
