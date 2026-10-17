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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@OptIn(ExperimentalMaterial3Api::class)
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
                .clip(
                    RoundedCornerShape(
                        topStart = dimensionResource(id = R.dimen.card_corner_radius),
                        topEnd = dimensionResource(id = R.dimen.card_corner_radius)
                    )
                )
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
                    OutlinedTextField(
                        value = textNamaBelakang,
                        onValueChange = { textNamaBelakang = it },
                        label = { Text(stringResource(id = R.string.nama_belakang)) },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = MaterialTheme.shapes.large
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))

                OutlinedTextField(
                    value = textEmail,
                    onValueChange = { textEmail = it },
                    label = { Text(stringResource(id = R.string.email)) },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = MaterialTheme.shapes.large
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                ) {
                    OutlinedTextField(
                        value = textTglLahir,
                        onValueChange = { },
                        readOnly = true,
                        label = { Text(stringResource(id = R.string.tgl_lahir)) },
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Icon(Icons.Default.DateRange, contentDescription = null)
                            }
                        },
                        modifier = Modifier.weight(1f),
                        singleLine = true,
                        shape = MaterialTheme.shapes.large
                    )
                    ExposedDropdownMenuBox(
                        expanded = expandedDropdown,
                        onExpandedChange = { expandedDropdown = !expandedDropdown },
                        modifier = Modifier.weight(1f)
                    ) {
                        OutlinedTextField(
                            value = textExperience,
                            onValueChange = { },
                            readOnly = true,
                            label = { Text(stringResource(id = R.string.experience)) },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown) },
                            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                            modifier = Modifier.menuAnchor(),
                            singleLine = true,
                            shape = MaterialTheme.shapes.large
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))

                    OutlinedTextField(
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        label = { Text(stringResource(id = R.string.email)) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true,
                        shape = MaterialTheme.shapes.large
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_medium)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_medium))
                    ) {
                        OutlinedTextField(
                            value = textTglLahir,
                            onValueChange = { },
                            readOnly = true,
                            label = { Text(stringResource(id = R.string.tgl_lahir)) },
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(Icons.Default.DateRange, contentDescription = null)
                                }
                            },
                            modifier = Modifier.weight(1f),
                            singleLine = true,
                            shape = MaterialTheme.shapes.large
                        )
                        ExposedDropdownMenuBox(
                            expanded = expandedDropdown,
                            onExpandedChange = { expandedDropdown = !expandedDropdown },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = textExperience,
                                onValueChange = { },
                                readOnly = true,
                                label = { Text(stringResource(id = R.string.experience)) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown) },
                                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                                modifier = Modifier.menuAnchor(),
                                singleLine = true,
                                shape = MaterialTheme.shapes.large
                            )
                            ExposedDropdownMenu(
                                expanded = expandedDropdown,
                                onDismissRequest = { expandedDropdown = false }
                            ) {
                                experienceOptions.forEach { selectionOption ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOption) },
                                        onClick = {
                                            textExperience = selectionOption
                                            expandedDropdown = false
                                        }
                                    )
                                }
                            }

                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_large)))

                    Text(
                        text = stringResource(id = R.string.skills_label),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = checkedAndroid,
                                onCheckedChange = { checkedAndroid = it })
                            Text(stringResource(id = R.string.skill_android))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = checkedUIUX, onCheckedChange = { checkedUIUX = it })
                            Text(stringResource(id = R.string.skill_uiux))
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(checked = checkedWeb, onCheckedChange = { checkedWeb = it })
                            Text(stringResource(id = R.string.skill_web))
                        }
                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_large)))

                        Button(
                            onClick = { showPopupDialog = true },
                            enabled = isDataValid,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(dimensionResource(id = R.dimen.btn_height)),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.purple_title),
                                disabledContainerColor = colorResource(id = R.color.gray_button)
                            ),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Text(
                                text = stringResource(id = R.string.btn_proceed),
                                color = if (isDataValid) Color.White else Color.Black,
                                fontWeight = FontWeight.Bold
                            )

                        }

                    }
                }
            }
            if (showPopupDialog) {
                Dialog(onDismissRequest = { showPopupDialog = false }) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 24.dp,
                                shape = RoundedCornerShape(16.dp),
                                ambientColor = colorResource(id = R.color.blue_shadow_transparent),
                                spotColor = colorResource(id = R.color.blue_shadow_transparent)
                            ),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.blue_popup_bg))
                    ) {
                        Column(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))) {
                            Text(
                                text = stringResource(id = R.string.dialog_title),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = colorResource(id = R.color.purple_title)
                            )
                        }
                    }
                }
            }
        }
    }
}