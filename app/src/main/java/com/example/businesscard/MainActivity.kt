package com.example.businesscard

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
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
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        NameAndJobTitle(
            name = stringResource(R.string.full_name),
            jobTitle = stringResource(R.string.job_title),
            idPicture = painterResource(id = R.drawable.ac_girl)
        )
        ContactInfo(
            phone = stringResource(R.string.phone_number),
            phoneIcon = Icons.Default.Phone,
            socMed = stringResource(R.string.socmed_link),
            socMedShareIcon = Icons.Default.Share,
            email = stringResource(R.string.email_address),
            emailIcon = Icons.Default.Email
        )
    }
}

@Composable
fun NameAndJobTitle(
    name: String,
    jobTitle: String,
    idPicture: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight(.6f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = idPicture,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .padding(bottom = 10.dp)
                .size(200.dp)
        )
        Text(text = name)
        Text(text = jobTitle)
    }
}

@Composable
fun ContactInfo(
    phone: String,
    phoneIcon: ImageVector,
    socMed: String,
    socMedShareIcon: ImageVector,
    email: String,
    emailIcon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFDCEDC8)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = phoneIcon,
                contentDescription = stringResource(R.string.mail_icon),
                modifier = modifier
                    .padding(end = 5.dp)
                    .offset(x = -4.dp),
                tint = Color.Black
            )
            Text(text = phone)
        }
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = socMedShareIcon,
                contentDescription = stringResource(R.string.share_icon),
                modifier = modifier
                    .padding(end = 5.dp)
                    .offset(x = -14.dp),
                tint = Color.Black
            )
            Text(text = socMed,
                modifier = modifier.offset(x=-6.dp))
        }
        Row(modifier = modifier.padding(5.dp)) {
            Icon(
                imageVector = emailIcon,
                contentDescription = stringResource(R.string.mail_icon),
                modifier = modifier.padding(end = 5.dp),
                tint = Color.Black
            )
            Text(text = email,
                modifier = modifier.offset(x=8.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting()
    }
}