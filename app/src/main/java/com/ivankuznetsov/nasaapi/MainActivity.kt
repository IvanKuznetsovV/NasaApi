package com.ivankuznetsov.nasaapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ivankuznetsov.nasaapi.presentation.navigation.Screen
import com.ivankuznetsov.nasaapi.presentation.screens.DatesScreen
import com.ivankuznetsov.nasaapi.presentation.screens.PhotoByDateScreen
import com.ivankuznetsov.nasaapi.presentation.screens.PhotoScreen
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ivankuznetsov.nasaapi.presentation.viewmodels.DatesViewModel
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Dates.route){
                    composable(Screen.Dates.route){ navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        //val viewModel: DatesViewModel = viewModel("DatesViewModel", factory)
                        DatesScreen() }
                    composable(Screen.PhotoByDate.route){ PhotoByDateScreen() }
                    composable(Screen.Photo.route){ PhotoScreen() }
                }
        }
    }

}


