package com.example.tugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun FormBiodataLayout(modifier: Modifier = Modifier) {
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }

    var textTglLahir by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var textExperience by remember { mutableStateOf("") }
    var expandedDropdown by remember { mutableStateOf(false) }
    val experienceOptions = listOf(
        stringResource(id = R.string.exp_less_1),
        stringResource(id = R.string.exp_less_2),
        stringResource(id = R.string.exp_more_3)
    )
    var checkedAndroid by remember { mutableStateOf(false) }
    var checkedUIUX by remember { mutableStateOf(false) }
    var checkedWeb by remember { mutableStateOf(false) }

    var showPopupDialog by remember { mutableStateOf(false) }

    val isDataValid = textNamaDepan.isNotEmpty() &&
            textEmail.isNotEmpty() &&
            textTglLahir.isNotEmpty()

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.fstvlst),
            contentDescription = stringResource(id = R.string.img_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.header_height))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.card_top_offset))
                .clip(RoundedCornerShape(
                    topStart = dimensionResource(id = R.dimen.card_corner_radius),
                    topEnd = dimensionResource(id = R.dimen.card_corner_radius)
                ))
                .background(colorResource(id = R.color.white_background))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_large))
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.form_judul),
                    color = colorResource(id = R.color.purple_title),
                    fontSize = dimensionResource(id = R.dimen.text_title).value.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_small)))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                ) {
                    OutlinedTextField(
                        value = textNamaDepan,
                        onValueChange = { textNamaDepan = it },
                        label = { Text(stringResource(id = R.string.nama_depan)) },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = MaterialTheme.shapes.large
                    )
                }

                }

        }

        }
}
