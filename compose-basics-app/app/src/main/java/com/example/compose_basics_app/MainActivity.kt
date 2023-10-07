package com.example.compose_basics_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_basics_app.ui.theme.ComposebasicsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposebasicsappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    ComposeArticle()
//                    TaskManager()
                    ComposeQuadrants()
                }
            }
        }
    }
}


// COMPOSE ARTICLE

@Composable
fun ComposeArticle(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(
            painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        TitleText(
            text = stringResource(R.string.compose_tutorial_title)
        )
        DescriptionText(
            text = stringResource(R.string.compose_description_paragraph_1),
            Modifier.padding(16.dp, 0.dp)
        )
        DescriptionText(
            text = stringResource(R.string.compose_description_paragraph_2),
            Modifier.padding(16.dp)
        )
    }

}

@Composable
fun TitleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        fontSize = 24.sp,
        modifier = modifier.padding(16.dp)
    )
}

@Composable
fun DescriptionText(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}


// TASK MANAGER

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painterResource(R.drawable.ic_task_completed),
            contentDescription = "Tick mark for all tasks completed"
        )
        Text(
            text = stringResource(R.string.all_taks_completed_text),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.nice_work_text),
            fontSize = 16.sp,
        )
    }
}


// COMPOSE QUADRANT

@Composable
fun ComposeQuadrants() {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.compose_quadrant_1_title),
                description = stringResource(R.string.compose_quadrant_1_description),
                color = colorResource(R.color.violet_200),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.compose_quadrant_2_title),
                description = stringResource(R.string.compose_quadrant_2_description),
                color = colorResource(R.color.violet_500),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposeQuadrant(
                title = stringResource(R.string.compose_quadrant_3_title),
                description = stringResource(R.string.compose_quadrant_3_description),
                color = colorResource(R.color.violet_700),
                modifier = Modifier.weight(1f)
            )
            ComposeQuadrant(
                title = stringResource(R.string.compose_quadrant_4_title),
                description = stringResource(R.string.compose_quadrant_4_description),
                color = colorResource(R.color.violet_50),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposeQuadrant(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color)
            .padding(16.dp)
            .fillMaxHeight()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposebasicsappTheme {
//        ComposeArticle()
//        TaskManager()
        ComposeQuadrants()
    }

}