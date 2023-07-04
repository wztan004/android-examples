package com.example.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    Sample()
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, message: String, color: Color, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = color)
            .padding(16.dp)
            .fillMaxSize()


    ) {

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Text(
            text = message,
            textAlign = TextAlign.Center,
        )

    }
}


@Composable
fun BoxWithLayout(content: @Composable RowScope.()->Unit) {
    Row {
        content()
    }
}

@Composable
private fun Sample() {
    BoxWithLayout {
        Column(Modifier.weight(1f)) {
            Row(Modifier.weight(1f)) {
                Quadrant(title ="Text composable", message="Displays text and follows the recommended Material Design guidelines.", color = Color(0xFFEADDFF))
            }
            Row(Modifier.weight(1f)) {
                Quadrant(title ="Image composable", message="Creates a composable that lays out and draws a given Painter class object.", color = Color(0xFFD0BCFF))
            }
        }
        Column(Modifier.weight(1f)) {
            Row(Modifier.weight(1f)) {
                Quadrant(title ="Row composable", message="A layout composable that places its children in a horizontal sequence.", color = Color(0xFFB69DF8))
            }
            Row(Modifier.weight(1f)) {
                Quadrant(title ="Column composable", message="A layout composable that places its children in a vertical sequence.", color = Color(0xFFF6EDFF))
            }
        }

    }
}



@Preview
@Composable
fun SamplePreview() {
    Sample()
}
