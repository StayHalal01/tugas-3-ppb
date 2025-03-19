package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE8EAF6) // Light lavender background
                ) {
                    BirthdayCard(message = "Happy Birthday Sam!", from = "From Emma")
                }
            }
        }
    }
}

@Composable
fun BirthdayCard(message: String, from: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Yellow strip at the top
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .height(20.dp)
                        .padding(top = 16.dp)
                        .background(
                            color = Color(0xFFFFE082), // Light yellow
                            shape = RoundedCornerShape(8.dp)
                        )
                )

                Spacer(modifier = Modifier.height(60.dp))

                // Message text
                Text(
                    text = "Happy",
                    fontSize = 36.sp,
                    color = Color(0xFF3F51B5), // Indigo
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Birthday",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF3F51B5), // Indigo
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "To Us!",
                    fontSize = 56.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFF9800), // Orange
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(60.dp))

                // From text with light background
                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 24.dp, bottom = 24.dp)
                        .background(
                            color = Color(0xFFF5F5F5), // Very light gray
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = from,
                        fontSize = 15.sp,
                        color = Color(0xFF5D4037) // Brown
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFE8EAF6) // Light lavender background
        ) {
            BirthdayCard(message = "Happy Birthday To Us!", from = "From Nobody")
        }
    }
}