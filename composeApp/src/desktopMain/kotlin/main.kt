import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import view.BlocoDeNotasComponentes


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BlocoDeNotasDataStore",
    ) {
        BlocoDeNotasComponentes()
    }
}