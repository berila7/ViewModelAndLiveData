package com.example.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityModel
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainActivityModel::class.java]
        val btn = findViewById<Button>(R.id.btnCount)
        val countView = findViewById<TextView>(R.id.tvCount)
        val dcBtn = findViewById<Button>(R.id.dcBtn)
        val reset = findViewById<Button>(R.id.resetBtn)

//        countView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            countView.text = it.toString()
        })
//        viewModel.count = 0
        btn.setOnClickListener {
            viewModel.increase()
//            countView.text = viewModel.count.toString()
        }

        dcBtn.setOnClickListener {
            viewModel.decrease()
//            countView.text = viewModel.count.toString()
        }

        reset.setOnClickListener {
//            viewModel.count = 0
//            countView.text = viewModel.count.toString()
            viewModel.resetCount()
        }
    }
}