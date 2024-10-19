package com.example.toy.architecture

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.toy.databinding.ActivityMvvmactivityBinding


class MyViewModel : ViewModel() {
    private val _data = MutableLiveData<String>()
    val data: LiveData<String> get() = _data

    fun fetchData() {
        _data.value = "데이터 업데이트"
    }

}


class MVVMActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmactivityBinding
    private val viewModel: MyViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchData()

        viewModel.data.observe(this) {
            binding.tvText.text = it
        }

    }
}