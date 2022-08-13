package com.ds.ds95

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ds.ds95.ui.theme.Ds95Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Ds95Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Preview(
    widthDp = 150,
    heightDp = 80
)
@Composable
fun Background(
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
                    awaitRelease()
                    pressed = false
                }
            )
        }
    ) {
        Surface(
            color = Color.Black,
            modifier = Modifier
                .background(color = Color.Black)
                .padding(
                    if (pressed) {
                        2.dp
                    } else {
                        0.dp
                    }
                )
        ) {
            Surface(
                color = Color.White,
                modifier = Modifier.padding(end = 2.dp, bottom = 2.dp)
            ) {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 2.dp, top = 2.dp)
                ) {
                    Surface(
                        color = Color.Gray,
                        modifier = Modifier.padding(end = 2.dp, bottom = 2.dp)
                    ) {
                        content()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Background(
            modifier = Modifier
                .width(150.dp)
                .height(80.dp)
        ) {
            Text(text = "Hello $name! 1")
        }

        Background(
            modifier = Modifier
                .width(150.dp)
                .height(80.dp)
        ) {
            Text(text = "Hello $name! 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ds95Theme {
        Greeting("Android")
    }
}