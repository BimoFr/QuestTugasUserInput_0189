package com.example.tugasuserinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

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


    }
}
