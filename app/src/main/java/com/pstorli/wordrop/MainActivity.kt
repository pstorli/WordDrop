package com.pstorli.wordrop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pstorli.wordrop.domain.data.Game
import com.pstorli.wordrop.domain.model.Vm
import com.pstorli.wordrop.ui.theme.WordDropTheme
import com.pstorli.wordrop.util.Consts.SQ_SZ
import com.pstorli.wordrop.util.Consts.TOP
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

        // TOP is padding for top area of app.
        val rows = ((screenHeight-TOP)/SQ_SZ).toInt()
        val cols = (screenWidth/SQ_SZ).toInt()

        // Start the game
        vm.createGame (rows, cols)

        Box(
            // The Box itself fills the available space
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background (Color.White))
        {
            // Gap at top, possibly buttons here later
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(TOP)
                    .background(Color.LightGray))
            {
                Spacer (modifier = Modifier.width(16.dp))
            }

            Image(
                painter = painterResource(id = R.drawable.ic_square),
                contentDescription = "My image1",
                modifier = Modifier
                    .offset(x = 0.dp, y = TOP)
                    .height(SQ_SZ)
                    .width(SQ_SZ),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Green)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_square),
                contentDescription = "My image2",
                modifier = Modifier
                    .offset(x = SQ_SZ, y = TOP+200.dp)
                    .height(SQ_SZ)
                    .width(SQ_SZ),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Magenta)
            )
        }
    }
}

