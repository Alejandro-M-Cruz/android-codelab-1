package com.example.clickbehaviorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehaviorapp.ui.theme.ClickBehaviorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorAppTheme {
                ClickBehaviorApp()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ClickBehaviorApp() {
    ClickBehaviorImageText(modifier = Modifier.fillMaxSize())
}

@Composable
fun ClickBehaviorImageText(modifier: Modifier = Modifier) {
    var uiState by remember {
        mutableStateOf(ClickBehaviorUiState())
    }
    val steps = arrayOf(
        LemonadeStep(
            imageResourceId = R.drawable.lemon_tree,
            stringResourceId = R.string.lemon_tree
        ),
        LemonadeStep(
            imageResourceId = R.drawable.lemon_squeeze,
            stringResourceId = R.string.lemon_squeeze,
            requiredClicksToChange = (2..4).random()
        ),
        LemonadeStep(
            imageResourceId = R.drawable.lemon_drink,
            stringResourceId = R.string.lemon_drink
        ),
        LemonadeStep(
            imageResourceId = R.drawable.lemon_restart,
            stringResourceId = R.string.lemon_restart
        )
    )
    val currentStep = steps[uiState.currentStepIndex]
    val text = stringResource(currentStep.stringResourceId)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Button(onClick = {
            uiState.clicks++
            if (uiState.clicks < currentStep.requiredClicksToChange) {
                return@Button
            }
            val nextStepIndex = uiState.currentStepIndex + 1
            uiState = ClickBehaviorUiState(
                clicks = 0,
                currentStepIndex = if (nextStepIndex < steps.size) nextStepIndex else 0
            )
        }) {
            Image(
                painter = painterResource(id = currentStep.imageResourceId),
                contentDescription = text
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = text, fontSize = 18.sp)
    }
}


data class LemonadeStep(
    val imageResourceId: Int,
    val stringResourceId: Int,
    val requiredClicksToChange: Int = 1
)


data class ClickBehaviorUiState(
    var clicks: Int = 0,
    var currentStepIndex: Int = 0
)

