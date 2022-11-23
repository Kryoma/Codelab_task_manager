package com.example.codelab_task_manager

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codelab_task_manager.ui.theme.Codelab_task_managerTheme
import java.util.SimpleTimeZone

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Codelab_task_managerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TaskManagerApp()
                }
            }
        }
    }
}

@Composable
private fun TaskManagerApp() {
    val image: Painter = painterResource(R.drawable.ic_task_completed)
    val completedMessage: String = stringResource(R.string.completed_message)
    val niceWorkMessage: String = stringResource(R.string.nice_work_message)

    TaskCompletedImageView(image, completedMessage, niceWorkMessage)
}

@Composable
fun TaskCompletedImageView(image: Painter, completedMessage: String, niceWorkMessage: String) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image, contentDescription = null
        )
        Text(
            text = completedMessage,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = niceWorkMessage,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Codelab_task_managerTheme {
        TaskManagerApp()
    }
}