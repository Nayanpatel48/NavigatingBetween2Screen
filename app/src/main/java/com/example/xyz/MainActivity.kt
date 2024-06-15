package com.example.xyz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.xyz.ui.theme.XyzTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XyzTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(1) }

    Surface(modifier) {
        if (shouldShowOnboarding==1) {
                FirstScreen(
                    onButton1Clicked = { shouldShowOnboarding = 2 },
                    onButton2Clicked = { shouldShowOnboarding = 3}
                )
        }
        else if (shouldShowOnboarding==2) {
            SecondScreen(onContinueClicked = { shouldShowOnboarding = 1 })
        }
        else if (shouldShowOnboarding==3) {
            ThirdScreen(onContinueClicked = { shouldShowOnboarding = 1 })
        }
        else {
            SecondScreen(onContinueClicked = { shouldShowOnboarding = 1 })
        }
    }
}
@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    onButton1Clicked: () -> Unit,
    onButton2Clicked: () -> Unit,
    ) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Row {
            //button 1
            Button(
                modifier = Modifier
                    .padding(vertical = 24.dp),
                onClick = onButton1Clicked
            ) {
                Text("Screen2")
            }
            //button 2
            Button(
                modifier = Modifier
                    .padding(vertical = 24.dp),
                onClick = onButton2Clicked
            ) {
                Text("Screen3")
            }
        }
    }
}
@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen-3")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Back")
        }
    }
}
@Composable
fun SecondScreen(modifier: Modifier = Modifier,
        onContinueClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen-2")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Back")
        }
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PreviewFirstScreen() {
    XyzTheme {
        FirstScreen(modifier = Modifier.fillMaxSize(), { },{ })
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PreviewSecondScreen() {
    XyzTheme {
        SecondScreen(modifier = Modifier.fillMaxSize(), { })
    }
}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun PreviewThirdScreen() {
    XyzTheme {
        ThirdScreen(modifier = Modifier.fillMaxSize(), { })
    }
}