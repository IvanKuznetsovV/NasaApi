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
import com.ivankuznetsov.nasaapi.presentation.viewmodels.PhotoByDateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Dates.route){
                    composable(Screen.Dates.route){ navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: DatesViewModel = viewModel(key = "DatesViewModel",factory = factory)
                        DatesScreen(onNavigateToPhotoByDateScreen = navController :: navigate,
                                    viewModel = viewModel)
                    }
                    composable(Screen.PhotoByDate.route){ navBackStackEntry ->
                        val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                        val viewModel: PhotoByDateViewModel = viewModel(key = "PhotoByDateViewModel", factory = factory)
                        PhotoByDateScreen(onNavigateToPhotoScreen = navController :: navigate,
                                          viewModel = viewModel) }
                    composable(Screen.Photo.route){ PhotoScreen() }
                }
        }
    }

}



