package com.xpresspayments.babamovieapp.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.xpresspayments.babamovieapp.R
import com.xpresspayments.babamovieapp.ui.theme.LightGray
import com.xpresspayments.babamovieapp.ui.theme.Purple500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.explore),
                color = if (isSystemInDarkTheme()) LightGray else Color.White
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors (
            containerColor = if (isSystemInDarkTheme()) Color.Black else Purple500,
            navigationIconContentColor = Color.LightGray,
            titleContentColor = if (isSystemInDarkTheme()) LightGray else Color.White,
        ),
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = if (isSystemInDarkTheme()) Color.White else Color.White
                )
            }
        }
    )
}

@Composable
@Preview
fun HomeTopBarPreview() {
    HomeTopBar {  }
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeTopBarDarkPreview() {
    HomeTopBar {  }
}