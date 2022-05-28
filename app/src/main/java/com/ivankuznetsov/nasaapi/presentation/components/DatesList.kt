package com.ivankuznetsov.nasaapi.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ivankuznetsov.nasaapi.data.model.Date
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.MutableState
import com.ivankuznetsov.nasaapi.presentation.navigation.Screen
import com.ivankuznetsov.nasaapi.presentation.viewmodels.DatesViewModel
import com.ivankuznetsov.nasaapi.util.TAG

@Composable
fun DatesList(viewModel: DatesViewModel, dateId: MutableState<String>, dates: List<Date>, onNavigateToPhotoByDateScreen: (String) -> Unit){
    Box(modifier = Modifier.background(color = MaterialTheme.colors.surface)) {
        if(dates.isEmpty()){
            LoadingDatesList(imageHeight = 25.dp)
        }
        else {
            LazyColumn {
                items(dates) { message ->
                    DatesListCard(message, onClick = {
                        dateId.value = message.date
                        val route = Screen.PhotoByDate.route
                        onNavigateToPhotoByDateScreen(route)
                    })
                }
            }
        }
    }
}

