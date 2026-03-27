package ua.melnyk.crossplatf

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import co.touchlab.kermit.Logger
import crossplatf.composeapp.generated.resources.Res

import crossplatf.composeapp.generated.resources.honk
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import ua.melnyk.crossplatf.ui.theme.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = {
                showContent = !showContent
                Logger.i { "Logger test."}
            }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val currentTime = remember { TimeZoneHelperImpl().currentTime() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                      text = "Current time: $currentTime",
                      style = TextStyle(
                          fontSize = 28.sp,
                          fontFamily = FontFamily(
                              Font(Res.font.honk)
                          ),
                          color = Color.White
                      )
                    );
                }
            }
        }
    }
}