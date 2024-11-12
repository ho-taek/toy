package com.example.toy.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

val LocalStaticValue = staticCompositionLocalOf { "기본값" }

val LocalDynamicValue = compositionLocalOf { "변할 수 있는 값" }


@Composable
fun CompositionLocalExample() {

    val localContentColor = staticCompositionLocalOf { Color.Red }

    Column {
        Text("상위 컴포저블")
        CompositionLocalProvider(localContentColor provides localContentColor.current) {
            Text("컴포저블")
            Text("컴포저블")
            CompositionLocalProvider(localContentColor provides Color.Blue) {
                DescendantExample()
            }
        }
    }
}


@Composable
fun DescendantExample() {
    Text("하위 컴포넌트")
}

@Preview(showBackground = true)
@Composable
fun CompositionLocalPreview() {
    CompositionLocalExample()
}