package org.data.store.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.data.store.R
import org.data.store.dataStore.StoreAnotacao

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable

fun BlocoDeNotasComponentes() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val storeAnotacao = StoreAnotacao(context)
    val anotacaoSalva = storeAnotacao.getAnotacao.collectAsState(initial = "" )

    var anotacao by remember {
        mutableStateOf("")
    }

    anotacao = anotacaoSalva.value

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Yellow
            ) {
                Text(
                    text = "Bloco de Notas",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        storeAnotacao.salvarAnotacao(anotacao)
                        Toast.makeText(context, "Anotação salva com sucesso", Toast.LENGTH_SHORT).show()
                    }
                },
                backgroundColor = Color.Yellow,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 8.dp
                )

            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_save),
                    contentDescription = "Ícone de salvar anotação")
            }
        }

    ) {
        Column {
            TextField(
                value = anotacao,
                onValueChange = {
                    anotacao =it
                },
                label = {
                    Text("Digite a sua anotação")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    cursorColor = Color.Black,
                    focusedLabelColor = Color.White
                )
            )
        }

    }


}