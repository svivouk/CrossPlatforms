package ua.melnyk.crossplatf.ui.screens.switchsc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.AlignmentLine
import ua.melnyk.crossplatf.ui.screens.divider.VerticalDividerExample
import ua.melnyk.crossplatf.ui.theme.primaryContainerDark
import ua.melnyk.crossplatf.ui.theme.primaryDark
import ua.melnyk.crossplatf.ui.theme.secondaryContainerDark
import ua.melnyk.crossplatf.ui.theme.secondaryDark

@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}

@Composable
fun SwitchWithCustomColors() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = primaryDark,
            checkedTrackColor = primaryContainerDark,
            uncheckedThumbColor = secondaryDark,
            uncheckedTrackColor = secondaryContainerDark,
        )
    )
}

@Composable
fun SwitchScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
    SwitchWithCustomColors()

    SwitchMinimalExample()

    SwitchWithIconExample()
    }

}