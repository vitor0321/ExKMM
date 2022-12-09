package com.kmm.android.ui.compoents

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kmm.android.AndroidAppTheme

@Composable
fun OutlinedButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    OutlinedButton(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun DefaultButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
@Preview
fun ButtonsPreview(){
    AndroidAppTheme {
        Column {
            OutlinedButton(text = "Botão Superior" )
            Spacer(modifier = Modifier.height(12.dp))
            DefaultButton(text = "Botão Inferiror")
        }
    }
}