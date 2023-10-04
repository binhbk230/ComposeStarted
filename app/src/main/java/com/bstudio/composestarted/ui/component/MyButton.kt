package com.bstudio.composestarted.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bstudio.composestarted.ui.theme.MyBlue
import com.bstudio.composestarted.ui.theme.MyBlueDisable
import com.bstudio.composestarted.ui.theme.White50


@Composable
fun MyButton(modifier: Modifier = Modifier, colors: ButtonColors, enabled: Boolean = true, content: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onClick.invoke() },
        colors = colors,
        enabled = enabled
    ) {
        Text(text = content)
    }
}

@Composable
@Preview
fun PreviewButton() {
    MyButton(content = "My Button", enabled = true, modifier = Modifier.fillMaxWidth()) {

    }
}