package ua.melnyk.crossplatf.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import crossplatf.composeapp.generated.resources.Res
import crossplatf.composeapp.generated.resources.buttons
import crossplatf.composeapp.generated.resources.checkboxes
import crossplatf.composeapp.generated.resources.chips
import crossplatf.composeapp.generated.resources.date_picker_dialog
import crossplatf.composeapp.generated.resources.dialog
import crossplatf.composeapp.generated.resources.divider
import crossplatf.composeapp.generated.resources.progress_bar
import crossplatf.composeapp.generated.resources.radio_buttons
import crossplatf.composeapp.generated.resources.switch
import crossplatf.composeapp.generated.resources.timepicker_dialog
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import ua.melnyk.crossplatf.ui.screens.AppScreen



@Composable
fun MainScreen(
    onButtonClicked: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Buttons.name)
            },

        ) {
            Text(stringResource(Res.string.buttons))
        }



        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Checkboxes.name)
            }
        ) {
            Text(stringResource(Res.string.checkboxes))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Chips.name)
            }
        ) {
            Text(stringResource(Res.string.chips))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.DatePickers.name)
            }
        ) {
            Text(stringResource(Res.string.date_picker_dialog))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Dialogs.name)
            }
        ){
            Text(stringResource(Res.string.dialog))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Dividers.name)
            }
        ){
            Text(stringResource(Res.string.divider))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.ProgressBars.name)
            }
        ){
            Text(stringResource(Res.string.progress_bar))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.RadioButtons.name)
            }
        ){
            Text(stringResource(Res.string.radio_buttons))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.Switch.name)
            }
        ){
            Text(stringResource(Res.string.switch))
                
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonClicked(AppScreen.TimePicker.name)
            }
        ){
            Text(stringResource(Res.string.timepicker_dialog))

        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen(onButtonClicked = {})
}