package com.bstudio.composestarted.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bstudio.composestarted.ui.theme.MyBlue
import com.bstudio.composestarted.ui.theme.MyBlueDisable
import com.bstudio.composestarted.ui.theme.White50


@Composable
fun MyButton(modifier: Modifier = Modifier, enabled: Boolean = true, content: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MyBlue,
            disabledContainerColor = MyBlueDisable,
            disabledContentColor = White50
        ),
        enabled = enabled
    ) {
        Text(text = content)
    }
}

@Composable
@Preview
fun PreviewButton() {
    MyButton(content = "My Button", enabled = true) {

    }
}