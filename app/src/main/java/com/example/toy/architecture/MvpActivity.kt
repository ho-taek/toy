package com.example.toy.architecture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.toy.R
import com.example.toy.databinding.ActivityMvpBinding


interface MainView{
    fun showData(data : String)
}

class MainPresenter(private val view : MainView, private val model : MyModel){

    fun onButtonClicked(){
        val data = model.fetchData()
        view.showData(data)
    }

}

class MvpActivity : AppCompatActivity(), MainView {

    private lateinit var presenter : MainPresenter
    private lateinit var binding : ActivityMvpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this, MyModel())

        binding.tvText.setOnClickListener{
            presenter.onButtonClicked()
        }
    }

    override fun showData(data: String) {
        binding.tvText.text = data
    }
}

class MyModel{
    fun fetchData() : String{
        return "데이터 업데이트"
    }
}