package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxHeight(.6f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NameAndTitle("Ac Doe", "Android Software Engineer")
        }
        Column(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color(0xFFDCEDC8)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Contacts("123-456-7890", "socmed/ac", "ac@gmail.com")
        }
    }
}

@Composable
fun NameAndTitle(name: String, jobTitle: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            //add an actual picture
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = modifier.padding(30.dp)
        )
        Text(
            text = name
        )
        Text(
            text = jobTitle
        )
    }
}

@Composable
fun Contacts(phone: String, socMed: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        //learn how to justifyAlign icons and texts
    ) {
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Mail Icon",
                modifier = modifier.padding(end = 5.dp),
                tint = Color.Black
            )
            Text(text = phone)
        }
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share Icon",
                modifier = modifier.padding(end = 5.dp),
                tint = Color.Black
            )
            Text(text = socMed)
        }
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = Icons.Default.MailOutline,
                contentDescription = "Mail Icon",
                modifier = modifier.padding(end = 5.dp),
                tint = Color.Black
            )
            Text(text = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting("Android")
    }
}