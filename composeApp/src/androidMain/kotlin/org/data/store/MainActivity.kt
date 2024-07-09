package org.data.store


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.data.store.view.BlocoDeNotasComponentes


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BlocoDeNotasComponentes()
        }
    }
}



@Preview
@Composable
fun AppAndroidPreview() {
    BlocoDeNotasComponentes()
}