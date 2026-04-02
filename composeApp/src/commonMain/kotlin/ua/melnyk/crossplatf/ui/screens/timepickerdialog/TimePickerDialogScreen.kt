package ua.melnyk.crossplatf.ui.screens.timepickerdialog

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ua.melnyk.crossplatf.data.timezones.TimeZoneHelper

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialogScreen(timeZoneHelper: TimeZoneHelper) {
    var showStartPicker by remember { mutableStateOf(false) }

        val timePickerState = rememberTimePickerState(
        initialHour = 9,
        initialMinute = 0,
        is24Hour = false
    )

    var selectedHour by remember { mutableStateOf<Int?>(null) }
    var availableHours by remember { mutableStateOf<List<Int>>(emptyList()) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showStartPicker = true }) {
            Text("Select Start Hour")
        }

        if (selectedHour != null) {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Selected Start Hour: $selectedHour:00")
            Text("Good Hours for overlap: $availableHours")
        }

        if (showStartPicker) {
            TimePickerDialog(
                onDismissRequest = { showStartPicker = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            val hour = timePickerState.hour
                            selectedHour = hour

                            val targetTimezones = listOf("Europe/London", "America/New_York")
                            availableHours = timeZoneHelper.search(
                                startHour = hour,
                                endHour = 23,
                                timezoneStrings = targetTimezones
                            )
                            showStartPicker = false
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showStartPicker = false }) {
                        Text("Dismiss")
                    }
                },
                title = {
                    Text("X")
                }
            ) {
                TimePicker(state = timePickerState)
            }
        }
    }
}

