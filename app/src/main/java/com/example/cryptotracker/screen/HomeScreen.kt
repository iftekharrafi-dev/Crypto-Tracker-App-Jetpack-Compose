package com.example.cryptotracker.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotracker.R
import com.example.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column {
        LazyColumn {

            items(20){

                CoinListItem()

            }

        }
    }
}

@Composable
fun CoinListItem() {

    val contentColor = if (isSystemInDarkTheme()) {
        Color.White
    } else Color.Black

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = MaterialTheme.colorScheme.background)
            .padding(all = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.btc),
            contentDescription = null,
            tint = Color.Magenta
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp)
        ) {
            Text(text = "BTC", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = contentColor)
            Text(
                text = "Bitcoin",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = contentColor
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "$1,18,000",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Row(
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(percent = 100)
                ).background(color = MaterialTheme.colorScheme.error),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp).padding(start = 5.dp)

                )
                Text(
                    text = "-1.06",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White, modifier = Modifier.padding(end = 8.dp)
                )

            }
        }
    }

}

@PreviewLightDark
@Composable
private fun CoinListItemPreview() {

    CryptoTrackerTheme {
        HomeScreen()

    }

}