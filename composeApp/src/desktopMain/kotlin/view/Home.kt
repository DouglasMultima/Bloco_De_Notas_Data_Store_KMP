package view


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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import blocodenotasdatastore.composeapp.generated.resources.Res
import blocodenotasdatastore.composeapp.generated.resources.ic_save
import kotlinx.coroutines.launch


@Composable

fun BlocoDeNotasComponentes() {


    var anotacao by remember {
        mutableStateOf("")
    }



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


                },
                backgroundColor = Color.Yellow,


            ) {
                
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