package com.example.toy.flow

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.toy.Greeting
import com.example.toy.R
import com.example.toy.ui.theme.ToyTheme
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class FlowActivity : ComponentActivity() {
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

        val channel = Channel<Int>()

        lifecycleScope.launch {
            repeat(1000){
                channel.send(it)
            }
        }

        lifecycleScope.launch {
            val data = channel.receive()
            Log.d("TEST1", "$data")
        }

        lifecycleScope.launch {
            val data = channel.receive()
            Log.d("TEST2", "$data")
        }

        lifecycleScope.launch {
            val data = channel.receive()
            Log.d("TEST3", "$data")
        }
    }
}