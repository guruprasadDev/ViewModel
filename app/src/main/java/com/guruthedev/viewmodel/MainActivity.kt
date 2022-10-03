package com.guruthedev.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.guruthedev.viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

      //  binding.tvCount.text = viewModel.count.toString()

            viewModel.count.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })

        binding.countBtn.setOnClickListener {

            viewModel.updateCount()
            //binding.tvCount.text = viewModel.count.toString()
        }
    }
}