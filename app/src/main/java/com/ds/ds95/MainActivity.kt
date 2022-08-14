package com.ds.ds95

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ds.ds95.ui.theme.Ds95Theme
import com.ds.ds95.ui.theme.Pixel

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
    widthDp = 25,
    heightDp = 25,
    group = "checkbox"
)
@Composable
fun Checkbox(
    modifier: Modifier = Modifier,
    initialValue: Boolean = false,
    onStateChange: Boolean.() -> Unit = {},
    @DrawableRes resource: Int = R.drawable.ic_check
) {

    var isChecked by remember { mutableStateOf(initialValue) }

    SimpleBackground(
        modifier.clickable {
            isChecked = !isChecked
            onStateChange(isChecked)
        }
    ) {
        if (isChecked) {
            Box(
                Modifier
                    .background(Color.White)
                    .padding(Pixel)
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

@Preview(
    widthDp = 150,
    heightDp = 80,
    group = "background"
)
@Composable
fun SimpleBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {

    Surface(
        modifier,
        color = Color.Gray
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier.padding(top = Pixel, start = Pixel)
        ) {
            Surface(
                color = Color.DarkGray,
                modifier = Modifier.padding(bottom = Pixel, end = Pixel)
            ) {
                Surface(
                    color = Color.Red,
                    modifier = Modifier.padding(start = Pixel, top = Pixel)
                ) {
                    Surface(
                        color = Color.White,
                        modifier = Modifier.padding(bottom = Pixel, end = Pixel),
                        content = content
                    )
                }
            }
        }
    }

}

@Preview(
    widthDp = 150,
    heightDp = 80,
    group = "background"
)
@Composable
fun ElevatedBackground(
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
                .padding(
                    if (pressed) {
                        Pixel
                    } else {
                        0.dp
                    }
                )
        ) {
            Surface(
                color = Color.White,
                modifier = Modifier.padding(end = Pixel, bottom = Pixel)
            ) {
                Surface(
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = Pixel, top = Pixel)
                ) {
                    Surface(
                        color = Color.Gray,
                        modifier = Modifier.padding(end = Pixel, bottom = Pixel),
                        content = content
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Checkbox(
            Modifier.size(80.dp)
        )
        ElevatedBackground(
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
        ) {
            Text(text = "Hello $name! 1")
        }

        ElevatedBackground(
            modifier = Modifier
                .width(300.dp)
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