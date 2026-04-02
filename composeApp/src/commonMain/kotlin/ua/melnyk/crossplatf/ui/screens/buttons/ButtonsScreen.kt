package ua.melnyk.crossplatf.ui.screens.buttons

import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import crossplatf.composeapp.generated.resources.Res
import crossplatf.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource

@Composable
fun FilledButton(){
    Button(onClick = {
        Logger.i("Loggg")
    }){
        Text("Normal Field Button :D")
    }
}

@Composable
fun TonalButton(){
    FilledTonalButton(onClick = { }) {
        Text("Tonal")
    }
}
@Composable
fun OutlinedButtin(){
    OutlinedButton(onClick = {}) {
        Text("Outlined")
    }
}

@Composable
fun ElevatedButton(){
    ElevatedButton(onClick = {}) {
        Text("Elevated")
    }
}
@Composable
fun ButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FilledButton()
        TonalButton()
        OutlinedButtin()
        ElevatedButton()

    }
}