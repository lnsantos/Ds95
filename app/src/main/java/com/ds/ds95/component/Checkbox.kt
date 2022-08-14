package com.ds.ds95.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ds.ds95.R
import com.ds.ds95.ui.theme.BasicPixel5

@Composable
fun Ds95Checkbox(
    modifier: Modifier = Modifier,
    initialValue: Boolean = false,
    onStateChange: Boolean.() -> Unit = {},
    @DrawableRes resource: Int = R.drawable.ic_check
) {
    var isChecked by remember { mutableStateOf(initialValue) }

    Ds95SimpleBackground(
        modifier.clickable {
            isChecked = !isChecked
            onStateChange(isChecked)
        }
    ) {
        if (isChecked) {
            Box(
                Modifier
                    .background(Color.White)
                    .padding(BasicPixel5)
            ) {
                Image(
                    painter = painterResource(id = resource),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}