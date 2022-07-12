package com.example.composequadrantpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
                    ComposeQuadrant(
                        headingText = stringResource(R.string.text_heading),
                        bodyText = stringResource(R.string.text_body),
                        headingImg = stringResource(R.string.image_heading),
                        bodyTextImg = stringResource(R.string.image_body),
                        headingRow = stringResource(R.string.row_heading),
                        bodyTextRow = stringResource(R.string.row_body),
                        headingColumn = stringResource(R.string.column_heading),
                        bodyTextColumn = stringResource(R.string.column_body)
                    )
                }
            }
        }
    }
}

@Composable
fun TextComposable(headingText:String, bodyText:String) {
    Column {
        Text(text = headingText)
        Text(text = bodyText)
    }
}

@Composable
fun ImageComposable(headingImg:String, bodyTextImg:String) {
    Column {
        Text(text = headingImg)
        Text(text = bodyTextImg)
    }
}

@Composable
fun RowComposable(headingRow:String, bodyTextRow:String) {
    Column {
        Text(text = headingRow)
        Text(text = bodyTextRow)
    }
}

@Composable
fun ColumnComposable(headingColumn:String, bodyTextColumn:String) {
    Column {
        Text(text = headingColumn)
        Text(text = bodyTextColumn)
    }
}

@Composable
fun ComposeQuadrant(
    headingText: String,bodyText: String,
    headingImg: String, bodyTextImg: String,
    headingRow: String, bodyTextRow: String,
    headingColumn: String, bodyTextColumn: String
) {
    Row() {
        TextComposable(headingText = headingText, bodyText = bodyText)
        ImageComposable(headingImg = headingImg, bodyTextImg = bodyTextImg)
    }
    Row() {
        RowComposable(headingRow = headingRow, bodyTextRow = bodyTextRow)
        ColumnComposable(headingColumn = headingColumn, bodyTextColumn = bodyTextColumn)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    ComposeQuadrantPageTheme {
        ComposeQuadrant(
            headingText = stringResource(R.string.text_heading),
            bodyText = stringResource(R.string.text_body),
            headingImg = stringResource(R.string.image_heading),
            bodyTextImg = stringResource(R.string.image_body),
            headingRow = stringResource(R.string.row_heading),
            bodyTextRow = stringResource(R.string.row_body),
            headingColumn = stringResource(R.string.column_heading),
            bodyTextColumn = stringResource(R.string.column_body)
        )
    }
}