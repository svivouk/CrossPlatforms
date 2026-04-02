package ua.melnyk.crossplatf.ui.screens

import ua.melnyk.crossplatf.ui.screens.main.MainScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import crossplatf.composeapp.generated.resources.Res
import crossplatf.composeapp.generated.resources.back
import crossplatf.composeapp.generated.resources.buttons
import crossplatf.composeapp.generated.resources.checkboxes
import crossplatf.composeapp.generated.resources.chips
import crossplatf.composeapp.generated.resources.date_picker_dialog
import crossplatf.composeapp.generated.resources.dialog
import crossplatf.composeapp.generated.resources.divider
import crossplatf.composeapp.generated.resources.main
import crossplatf.composeapp.generated.resources.progress_bar
import crossplatf.composeapp.generated.resources.radio_buttons
import crossplatf.composeapp.generated.resources.switch
import crossplatf.composeapp.generated.resources.timepicker_dialog
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import ua.melnyk.crossplatf.data.timezones.TimeZoneHelper
import ua.melnyk.crossplatf.data.timezones.TimeZoneHelperImpl
import ua.melnyk.crossplatf.ui.screens.buttons.ButtonsScreen
import ua.melnyk.crossplatf.ui.screens.checkboxes.CheckBoxesScreen
import ua.melnyk.crossplatf.ui.screens.chips.ChipsScreen
import ua.melnyk.crossplatf.ui.screens.date_picker_dialog.DatePickerDialogScreen
import ua.melnyk.crossplatf.ui.screens.dialog.DialogScreen
import ua.melnyk.crossplatf.ui.screens.divider.DividerScreen
import ua.melnyk.crossplatf.ui.screens.progressbar.ProgressBarScreen
import ua.melnyk.crossplatf.ui.screens.radiobuttons.RadioButtonScreen
import ua.melnyk.crossplatf.ui.screens.switchsc.SwitchMinimalExample
import ua.melnyk.crossplatf.ui.screens.switchsc.SwitchScreen
import ua.melnyk.crossplatf.ui.screens.timepickerdialog.TimePickerDialogScreen

enum class AppScreen(val title: StringResource) {
    Main(title = Res.string.main),
    Buttons(title = Res.string.buttons),
    Checkboxes(title = Res.string.checkboxes),
    Chips(title = Res.string.chips),
    DatePickers(title = Res.string.date_picker_dialog),
    Dialogs(title = Res.string.dialog),
    Dividers(title = Res.string.divider),
    ProgressBars(title = Res.string.progress_bar),
    RadioButtons(title = Res.string.radio_buttons),
    Switch(title = Res.string.switch),
    TimePicker(title = Res.string.timepicker_dialog)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: AppScreen.Main.name
    val currentScreen = try {
        AppScreen.valueOf(currentRoute)
    } catch (e: IllegalArgumentException) {
        AppScreen.Main
    }

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            composable(route = AppScreen.Main.name) {
                MainScreen(
                    onButtonClicked = { routeName ->
                        navController.navigate(routeName)
                    }
                )
            }

            composable(route = AppScreen.Buttons.name) {
                ButtonsScreen()
            }
            composable(route = AppScreen.Checkboxes.name) {
                CheckBoxesScreen()
            }
            composable(route = AppScreen.Chips.name) {
                ChipsScreen()
            }
            composable (route = AppScreen.DatePickers.name){
                DatePickerDialogScreen()
            }
            composable (route = AppScreen.Dialogs.name){
                DialogScreen()
            }
            composable(route = AppScreen.Dividers.name)
            {
                DividerScreen()
            }
            composable(route = AppScreen.ProgressBars.name) {
                ProgressBarScreen()
            }
            composable(route = AppScreen.RadioButtons.name) {
                RadioButtonScreen()
            }
            composable(route = AppScreen.Switch.name) {
                SwitchScreen()
            }

            composable(route = AppScreen.TimePicker.name){
                val timeZoneHelper = remember { TimeZoneHelperImpl() }
                TimePickerDialogScreen(timeZoneHelper = timeZoneHelper)
            }
        }
    }
}