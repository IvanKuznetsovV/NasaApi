package com.ivankuznetsov.nasaapi.presentation.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ivankuznetsov.nasaapi.presentation.viewmodels.PhotoByDateViewModel


@Composable
fun PhotoByDateScreen(onNavigateToPhotoScreen: (String) -> Unit,
                      viewModel: PhotoByDateViewModel
){
    val photoByDate = viewModel.photoByDate.value
    Text(photoByDate?.size.toString())

}