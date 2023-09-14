package com.example.greetingtoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingtoandroid.ui.theme.GreetingToAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val painter = painterResource(id = R.drawable.bgm)
                val description = "My First background"
                val title = "I am on the moon";
                Row(
                    modifier = Modifier.padding(bottom = 20.dp)
                ) {
                    Text(
                        text = "Hi, My First Android App",
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(fontSize = 20.sp),
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 50.dp, start = 10.dp, end = 10.dp)
                ) {
                    ImageCard(painter = painter, contentDescription = description, title = title)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row {
        Column(
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxHeight(0.5f)
                .width(600.dp)
                .padding(top = 250.dp)
                .border(5.dp, Color.Magenta)
        ) {
            Text(
                text = "Welcome to my journey",
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Hello $name!"
            )
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                Column(modifier=Modifier.padding(10.dp)) {
                    Text(
                        text = "32 \u00B0",
                        style = TextStyle(fontSize = 40.sp, color = Color.White)
                    )
                    Text(text = "Clear", style = TextStyle(color= Color.White))
                    Text(text = "Dhaka, Bangladesh", style = TextStyle(color = Color.White))
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(fontSize = 16.sp, color = Color.White))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingToAndroidTheme {
        Greeting("Tushar")
    }
}