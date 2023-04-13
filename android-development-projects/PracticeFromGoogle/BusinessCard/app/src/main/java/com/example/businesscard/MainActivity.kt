@file:OptIn(ExperimentalGraphicsApi::class)

package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.hsv
import androidx.compose.ui.graphics.ExperimentalGraphicsApi
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

/**
 * Composable for the entire app
 * TODO: Simplify layout
 */
@Composable
fun BusinessCard() {
    Column(
        Modifier
            .background(hsv(235f, 32f, 15f))
    ) {

    }
}
/**
 * Composable for the QR code image
 * TODO: Always at the top and at the end
 * */
@Composable
fun QrCode() {
    Row (
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.End
            ) {
        R.drawable.ic_round_qr_code_18
    }
}

/**
 * Composable for personal image, name, and title.
 * TODO: Center vertically
 * */
@Composable
fun Identity() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.selfie),
            contentDescription = stringResource(R.string.identity_description)
        )
        Text(
            text = stringResource(R.string.identity_name),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = stringResource(R.string.identity_title),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

/**
 * Composable for contact information, ways to reach you
 * TODO: Always at the bottom
 * */
@Composable
fun ContactInfo() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
    ) {
        ContactMedium(
            contactMediumIcon = Icons.Rounded.Phone,
            contactMediumDescriptor = stringResource(R.string.phone_description_contact),
            contactInfo = stringResource(R.string.phone_contact)
        )
        ContactMedium(
            contactMediumIcon = Icons.Rounded.Share,
            contactMediumDescriptor = stringResource(R.string.share_description_contact),
            contactInfo = stringResource(R.string.share_contact)
        )
        ContactMedium(
            contactMediumIcon = Icons.Rounded.Email,
            contactMediumDescriptor = stringResource(R.string.email_description_contact),
            contactInfo = stringResource(R.string.email_contact)
        )
    }
}

/**
 * Composable row for each way someone could contact you.
 */
@Composable
fun ContactMedium(
    contactMediumIcon: ImageVector,
    contactMediumDescriptor: String,
    contactInfo: String
) {
    Row() {
        Icon(
            imageVector = contactMediumIcon,
            contentDescription = contactMediumDescriptor,
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Text(
            text = contactInfo,
            textAlign = TextAlign.End,
            modifier = Modifier
                .padding(start = 20.dp, end = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}