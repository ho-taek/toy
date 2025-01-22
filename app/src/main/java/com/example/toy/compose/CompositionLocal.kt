package com.example.toy.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

val LocalStaticValue = staticCompositionLocalOf { "기본값" }

val LocalDynamicValue = compositionLocalOf { "변할 수 있는 값" }


val LocalColor = staticCompositionLocalOf { Color.Red }

@Composable
fun CompositionLocalExample() {
    Column {
        Text("상위 컴포저블")
        CompositionLocalProvider(LocalColor provides Color.Red) {
            Text(
                modifier = Modifier.background(LocalColor.current),
                text = "컴포저블"
            )
            CompositionLocalProvider(LocalColor provides Color.Blue) {
                DescendantExample()
            }
        }
    }
}



@Composable
fun DescendantExample() {
    Text(
        modifier = Modifier.background(LocalColor.current),
        text = "하위컴포넌트"
    )
}


@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColor provides Color.Red,
        LocalContentColor provides Color.Black,
    ) {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun CompositionLocalPreview() {
    CompositionLocalExample()
}