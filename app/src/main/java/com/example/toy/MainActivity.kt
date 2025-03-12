package com.example.toy

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.toy.component.broadcast.MyReceiver
import com.example.toy.ui.theme.ToyTheme

enum class Day(val day : String){
    MONDAY("월요일"), TUESDAY("화요일");

    companion object{
        fun getDay(name : String) : Day{
            return values().find { it.name == name } ?: MONDAY
        }
    }
}

class MainActivity : ComponentActivity() {
    private val myReceiver = MyReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        val intent = Intent("com.example.toy.CUSTOM_ACTION").apply {
            putExtra("message", "이벤트 전달")
        }
        sendBroadcast(intent)

    }

    override fun onResume() {
        super.onResume()
        val filter = IntentFilter("android.intent.action.BOOT_COMPLETED")
        registerReceiver(myReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(myReceiver)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ToyTheme {
        Greeting("Android")
    }
}