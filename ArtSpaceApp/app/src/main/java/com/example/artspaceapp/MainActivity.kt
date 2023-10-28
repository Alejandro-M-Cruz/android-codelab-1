package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

data class Picture(
    @DrawableRes
    val image: Int,
    val title: String,
    val author: String,
    val year: Int
)

val pictures = arrayOf(
    Picture(R.drawable.book, "Best book", "John Doe", 2021),
    Picture(R.drawable.flower, "Flower", "Sam Smith", 2020),
    Picture(R.drawable.wood, "Wood", "Jane Doe", 2020),
    Picture(R.drawable.landscape, "Landscape", "Jane Doe", 2020),
)

@Composable
fun ArtSpaceApp() {
    var currentPictureIndex by remember { mutableStateOf(0) }
    val currentPicture = pictures[currentPictureIndex]

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        PictureCard(image = currentPicture.image, modifier = Modifier.wrapContentWidth())
        PictureDetailsCard(
            title = currentPicture.title,
            author = currentPicture.author,
            year = currentPicture.year,
            modifier = Modifier.wrapContentWidth()
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ActionButton(text = "Previous", onClick = {
                currentPictureIndex =
                    if (currentPictureIndex > 0) currentPictureIndex - 1 else pictures.lastIndex
            })
            ActionButton(text = "Next", onClick = {
                currentPictureIndex =
                     if (currentPictureIndex < pictures.lastIndex) currentPictureIndex + 1 else 0            })
        }
    }
}

@Composable
fun PictureCard(@DrawableRes image: Int, modifier: Modifier = Modifier) {
    Surface(shadowElevation = 16.dp, modifier = modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Composable
fun PictureDetailsCard(title: String, author: String, year: Int, modifier: Modifier = Modifier) {
    Surface(color = Color.LightGray, modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontSize = 32.sp, fontWeight = FontWeight.Light)
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = author, fontWeight = FontWeight.Bold)
                Text(
                    text = "($year)",
                    color = Color.DarkGray,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

@Composable
fun ActionButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceAppPreview() {
    ArtSpaceAppTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            ArtSpaceApp()
        }
    }
}


