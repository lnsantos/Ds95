package com.ds.ds95.component

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.ds.ds95.core.token.Tokens
import com.ds.ds95.ui.theme.BasicPixel5

@Composable
fun Ds95ElevatedBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    var pressed by remember { mutableStateOf(false) }

    Surface(
        color = Color.Black,
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onPress = {
                    pressed = true
                    tryAwaitRelease()
                    pressed = false
                }
            )
        }
    ) {
        Surface(
            color = Color.Black,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(if (pressed) BasicPixel5 else 0.dp)
        ) {
            Surface(
                color = Color.White,
                modifier = Modifier.padding(end = Tokens.size.smallPixel, bottom = BasicPixel5)
            ) {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = BasicPixel5, top = BasicPixel5)
                ) {
                    Surface(
                        color = Color.Gray,
                        modifier = Modifier.padding(end = BasicPixel5, bottom = BasicPixel5),
                        content = content
                    )
                }
            }
        }
    }
}