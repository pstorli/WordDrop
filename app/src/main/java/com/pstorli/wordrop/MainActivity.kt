package com.pstorli.wordrop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import com.pstorli.wordrop.domain.data.Game
import com.pstorli.wordrop.domain.model.Vm
import com.pstorli.wordrop.ui.theme.WordDropTheme
import com.pstorli.wordrop.util.Consts.SQ_SZ
import kotlin.div
import kotlin.getValue

class MainActivity : ComponentActivity() {
    val vm: Vm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WordDropTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WD(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GamePreview() {
        WordDropTheme {
            WD("Word Drop")
        }
    }

    @Composable
    fun WD(name: String, modifier: Modifier = Modifier) {
        // Get screen size
        val windowInfo  = LocalWindowInfo.current
        val screenWidth  = with(LocalDensity.current) { windowInfo.containerSize.width.toDp() }
        val screenHeight = with(LocalDensity.current) { windowInfo.containerSize.height.toDp() }

        val rows = (screenHeight/SQ_SZ).toInt()
        val cols = (screenWidth/SQ_SZ).toInt()

        // Start the game
        vm.createGame (rows, cols)

        Text(
            text = "Hello $name\n" +
                    "Screen width is $vm.screenWidth and \nScreen height is $vm.screenHeight",
            modifier = modifier
        )
    }
}

