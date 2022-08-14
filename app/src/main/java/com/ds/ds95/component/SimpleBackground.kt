package com.ds.ds95.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ds.ds95.ui.theme.BasicPixel5

@Composable
fun Ds95SimpleBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Surface(
        modifier,
        color = Color.Gray
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.padding(top = BasicPixel5, start = BasicPixel5)
        ) {
            Surface(
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = BasicPixel5, end = BasicPixel5)
            ) {
                Surface(
                    color = Color.Red,
                    modifier = Modifier.padding(start = BasicPixel5, top = BasicPixel5)
                ) {
                    Surface(
                        color = Color.White,
                        modifier = Modifier.padding(bottom = BasicPixel5, end = BasicPixel5),
                        content = content
                    )
                }
            }
        }
    }
}