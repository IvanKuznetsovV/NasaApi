package com.ivankuznetsov.nasaapi.presentation.navigation

sealed class Screen(val route: String){
    object Dates: Screen("dates")
    object PhotoByDate: Screen("photo_by_date")
    object Photo: Screen("photo")
}
