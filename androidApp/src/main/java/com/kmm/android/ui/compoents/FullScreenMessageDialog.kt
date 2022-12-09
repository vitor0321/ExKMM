package com.kmm.android.ui.compoents

import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kmm.android.AndroidAppTheme
import com.kmm.todo.R
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FullScreenMessageDialog(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String,
    bottomButtonText: String,
    bottomButtonAction: () -> Unit = {},
    loadingState: StateFlow<Boolean>
) {
    val loading by loadingState.collectAsState()
    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .weight(weight = 1f, fill = true)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val shimmerInstance = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
                if (loading) MessageContentWithShimmer(shimmerInstance) else MessageContent(icon, iconTint, title, message)
            }
            DefaultButton(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = bottomButtonText,
                onClick = bottomButtonAction
            )
        }
    }
}

@Composable
fun MessageContent(
    @DrawableRes icon: Int? = null,
    @ColorRes iconTint: Int? = null,
    title: String,
    message: String
) {
    icon?.let {
        Image(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp),
            painter = painterResource(id = it),
            contentDescription = "Error image",
            colorFilter = if (iconTint != null) ColorFilter.tint(colorResource(id = iconTint)) else ColorFilter.tint(Color.Red)

        )
    }
    Text(text = title, textAlign = TextAlign.Center)
    Text(text = message, modifier = Modifier.padding(top = 16.dp, bottom = 36.dp), textAlign = TextAlign.Center)
}

@Composable
fun MessageContentWithShimmer(shimmerInstance: Shimmer) {
    Box(
        modifier = Modifier
            .shimmer(shimmerInstance)
            .width(70.dp)
            .height(70.dp)
            .background(color = Color.Gray)
    )
    Spacer(
        modifier = Modifier
            .padding(top = 12.dp)
            .height(24.dp)
            .width(150.dp)
            .shimmer(shimmerInstance)
            .background(color = Color.Gray)
    )
    Spacer(
        modifier = Modifier
            .padding(top = 12.dp)
            .height(24.dp)
            .width(150.dp)
            .shimmer(shimmerInstance)
            .background(color = Color.Gray)
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun FullScreenMessageDialogPreview() {
    AndroidAppTheme {
        FullScreenMessageDialog(
            null,
            null,
            "titulo",
            "message",
            "bottomButtonText",
            {},
            MutableStateFlow(false)
        )
    }
}