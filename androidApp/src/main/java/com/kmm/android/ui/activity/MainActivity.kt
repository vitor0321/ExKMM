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
import androidx.compose.material.Button
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.kmm.android.AndroidAppTheme
import com.kmm.android.ui.compoents.FullScreenMessageDialog
import com.kmm.common.viewmodels.SampleViewModel
import com.kmm.common.viewmodels.ShimmerViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()
        val shimmerViewModel = ShimmerViewModel()

        setContent {
            AndroidAppTheme {
//                DatabaseVid(viewModel = viewModel)
                ShimmerVid(viewModel = shimmerViewModel)
            }
        }
    }
}

@Composable
fun ShimmerVid(viewModel: ShimmerViewModel) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        FullScreenMessageDialog(
            icon = android.R.drawable.stat_notify_error,
            iconTint = android.R.color.holo_red_light,
            title = "My Dialog",
            message = "This is my fancy body message!",
            bottomButtonText = "Toggle Shimmer",
            bottomButtonAction = { viewModel.toggleLoadingState() },
            loadingState = viewModel.loading
        )
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DatabaseVid(viewModel: SampleViewModel) {
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

@Preview
@Composable
fun DefaultPreview() {
    AndroidAppTheme {
    }
}
