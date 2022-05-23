package com.ivankuznetsov.nasaapi.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ivankuznetsov.nasaapi.data.model.Date
import com.ivankuznetsov.nasaapi.presentation.components.DatesList
import com.ivankuznetsov.nasaapi.presentation.viewmodels.DatesViewModel


@Composable
fun DatesScreen(onNavigateToPhotoByDateScreen: (String) -> Unit,
                viewModel: DatesViewModel
){
    DatesList()
}