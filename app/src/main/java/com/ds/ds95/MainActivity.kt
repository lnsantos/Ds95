package com.ds.ds95

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
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
    Surface(
        color = Color.Black,
        modifier = modifier
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

@Composable
fun Greeting(name: String) {
    Background(
        modifier = Modifier.width(150.dp).height(80.dp)
    ) {
        Text(text = "Hello $name!")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ds95Theme {
        Greeting("Android")
    }
}