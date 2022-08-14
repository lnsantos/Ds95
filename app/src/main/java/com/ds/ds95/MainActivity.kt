package com.ds.ds95

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ds.ds95.component.Ds95Button
import com.ds.ds95.component.Ds95Checkbox
import com.ds.ds95.component.Ds95ElevatedBackground
import com.ds.ds95.component.Ds95SimpleBackground
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

@Composable
fun Greeting(name: String) {
    Column {
        Text(text = "Checkbox")
        Ds95Checkbox(Modifier.size(80.dp))

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Background")
        Ds95ElevatedBackground(
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
        ) {
            Text(text = "Hello $name! 1")
        }

        Ds95SimpleBackground(
            modifier = Modifier
                .width(300.dp)
                .height(80.dp)
        ) {
            Text(text = "Hello $name! 1")
        }

        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Button")
        Ds95Button(
            text = "Simple Button"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Ds95Theme {
        Greeting("Android")
    }
}