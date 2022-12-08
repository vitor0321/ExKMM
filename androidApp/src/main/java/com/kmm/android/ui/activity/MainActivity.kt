package com.kmm.android.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.kmm.android.MyApplicationTheme
import com.kmm.common.models.Story
import com.kmm.common.viewmodels.SampleViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val stories by viewModel.stories.collectAsState()
                    val error by viewModel.error.collectAsState()
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(text = "SqlDeLight KMM", style = LocalTextStyle.current.copy(), fontSize = TextUnit(24f, TextUnitType.Sp))

                        if (error) {
                            Text(text = "Something is wrong")
                        } else {
                            Row {
                                Button(onClick = { viewModel.loadStories() }) {
                                    Text(text = "Load Stories")
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Button(onClick = { viewModel.clearStories() }) {
                                    Text(text = "Clear Stories")
                                }
                            }

                            stories.forEach { story ->
                                Text(text = story.name)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
