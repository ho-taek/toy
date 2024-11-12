package com.example.toy.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.toy.Greeting
import com.example.toy.ui.theme.ToyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun fetchUserData(userId : String) : String{
    delay(3000)
    return "사용자 데이터는 $userId"
}


@Composable
fun LaunchedEffectExample(userId : String){
    
    var userData by remember { mutableStateOf<String?>(null) }
    
    LaunchedEffect(userId) {
        userData = fetchUserData(userId)
    }

    Text(text = userData ?: "로딩중...")
}

@Composable
fun RememberCoroutineScopeExample() {
    val coroutineScope = rememberCoroutineScope()
    var counter by remember { mutableStateOf(0) }

    Button(onClick = {
        coroutineScope.launch {
            // 버튼 클릭 시 비동기 작업 실행
            delay(1000)
            counter++
        }
    }) {
        Text(text = "Counter: $counter")
    }
}

@Composable
fun rememberUpdate(){
    RememberUpdatedStateExample {
        println("출력중!")
    }
}

@Composable
fun SideEffectExample(counter: Int) {
    // 이 작업은 상태 변화마다 실행됨
    SideEffect {
        Log.d("SideEffect", "$counter")
    }

    Text(text = "$counter")
}


@Composable
fun RememberUpdatedStateExample(onTimeout: () -> Unit) {
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    LaunchedEffect(Unit) {
        delay(5000)
        currentOnTimeout() // 최신의 onTimeout 호출
    }
}

@Composable
fun rememberUpdateWithout(name : String){
    var count by remember { mutableStateOf(0) }
    val updateName by remember { mutableStateOf(name) }

    LaunchedEffect(true) {
        while(true){
            delay(500)
            count++
        }
    }
    Text(text = "count $count name $name")
}

@Composable
fun rememberUpdate(name : String){
    var count by remember { mutableStateOf(0) }
    val updateName by rememberUpdatedState(newValue = name)

    LaunchedEffect(true) {
        while(true){
            delay(500)
            count++
        }
    }
    Text(text = "count $count name $updateName")
}



@Preview(showBackground = true)
@Composable
fun examplePreview() {


}