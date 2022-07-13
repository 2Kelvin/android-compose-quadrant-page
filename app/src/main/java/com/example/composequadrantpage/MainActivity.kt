package com.example.composequadrantpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrantpage.ui.theme.ComposeQuadrantPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantPage()
                }
            }
        }
    }
}

//reusable InfoCard
@Composable
fun InfoCard(
    title:String,
    description:String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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

//Compose Quadrant Page
// the "weight" property in both Rows ensures that the space is distributed equally
@Composable
fun ComposeQuadrantPage() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(R.string.text_heading),
                description = stringResource(R.string.text_body),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(R.string.image_heading),
                description = stringResource(R.string.image_body),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            InfoCard(
                title = stringResource(R.string.row_heading),
                description = stringResource(R.string.row_body),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                title = stringResource(R.string.column_heading),
                description = stringResource(R.string.column_body),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantPageTheme {
        ComposeQuadrantPage()
    }
}