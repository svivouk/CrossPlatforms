package ua.melnyk.crossplatf


import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import ua.melnyk.crossplatf.ui.screens.AppNavigation
import ua.melnyk.crossplatf.ui.theme.AppTheme



@Composable
@Preview
fun App() {
    AppTheme {
        AppNavigation()
    }

}