package com.example.business_card_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.business_card_app.model.ContactInformation
import com.example.business_card_app.ui.theme.BusinesscardappTheme

val contactInformation = ContactInformation(
    phone = "+34 123 456 789",
    email = "john.doe@example.com",
    website = "example.com"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinesscardappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard("John Doe", "Android Developer", contactInformation)
                }
            }
        }
    }
}

@Composable
fun BusinessCard(
    name: String,
    jobTitle: String,
    contactInformation: ContactInformation
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Presentation(name, jobTitle, modifier = Modifier.weight(1f))
        ContactInformationList(contactInformation)
    }
}

@Composable
fun Presentation(
    name: String,
    jobTitle: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(modifier = Modifier.width(200.dp)) {
            Image(
                painterResource(R.drawable.android_logo),
                contentScale = ContentScale.Fit,
                contentDescription = "Android logo",
                modifier = Modifier.background(colorResource(R.color.black))
            )
        }
        Text(
            text = name,
            fontSize = 52.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 54.sp
        )
        Text(
            text = jobTitle,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.purple_700)
        )
    }
}

@Composable
fun ContactInformationList(
    contactInformation: ContactInformation,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ContactInformationItem(
            text = contactInformation.email,
            icon = Icons.Rounded.Email,
            iconDescription = "Email",
            modifier = Modifier.padding(8.dp)
        )
        ContactInformationItem(
            text = contactInformation.phone,
            icon = Icons.Rounded.Phone,
            iconDescription = "Phone",
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        )
        if (contactInformation.website != null) {
            ContactInformationItem(
                text = contactInformation.website,
                icon = Icons.Rounded.Search,
                iconDescription = "Website",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun ContactInformationItem(
    text: String,
    icon: ImageVector,
    iconDescription: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            icon,
            contentDescription = iconDescription,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(text)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinesscardappTheme {
        BusinessCard("John Doe", "Android Developer", contactInformation)
    }
}