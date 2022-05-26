package com.ivankuznetsov.nasaapi.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ivankuznetsov.nasaapi.data.model.Date

@Composable
fun DatesListCard(date: Date, onClick: () -> Unit){
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(12.dp, 8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Surface {
            Text(
                text = date.date,
                fontSize = 20.sp,
                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(10.dp,8.dp)
                )
        }
    }

}
