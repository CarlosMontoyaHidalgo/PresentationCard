package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentationcard.ui.theme.PresentationCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardPamn()
                }
            }
        }
    }
}

@Composable
fun CardPamn(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.DarkGray)
            .padding(bottom = 90.dp)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Color.White)
        ) {
            val image = painterResource(id = R.drawable.icon_owl)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
        }
        Text(text = stringResource(R.string.name), color = Color.White)
        Text(text = stringResource(R.string.presentation_name), color = Color(0xFF3ddc84))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 500.dp)
            .padding(bottom = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        CustomRow(iconId = R.drawable.icon_phone, text = stringResource(R.string.telephone_number), modifier = Modifier)
        CustomRow(iconId = R.drawable.icon_email, text = stringResource(R.string.email), modifier = Modifier)
        CustomRow(iconId = R.drawable.icon_share, text = stringResource(R.string.share_information), modifier = Modifier)
    }
}

@Composable
fun CustomRow(iconId: Int, text: String, modifier: Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 40.dp),
    ) {
        val icon = painterResource(id = iconId)
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 60.dp)
                .size(40.dp),
                tint = Color(0xFF3ddc84))
        Text(text = text,
            modifier = Modifier.padding(start = 25.dp),
            color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        CardPamn()
    }
}