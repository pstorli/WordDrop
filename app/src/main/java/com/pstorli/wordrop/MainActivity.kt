package com.pstorli.wordrop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.pstorli.wordrop.ui.theme.WordDropTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WordDropTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting (name: String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val screenWidth = configuration.screenWidthDp
    Text(
        text = "Hello $name\n"+
                "Screen width is $screenWidth\n and screen height is $screenHeight",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview () {
    WordDropTheme {
        Greeting("Android")
    }
}