package com.ivankuznetsov.nasaapi.presentation.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ivankuznetsov.nasaapi.data.model.Date
import com.ivankuznetsov.nasaapi.presentation.components.DatesList
import com.ivankuznetsov.nasaapi.presentation.viewmodels.DatesViewModel


@Composable
fun DatesScreen(onNavigateToPhotoByDateScreen: (String) -> Unit,
                viewModel: DatesViewModel
                )
{
    val dates = viewModel.dates.value
    DatesList(dates = dates!!, onNavigateToPhotoByDateScreen)



}