package com.guruthedev.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.guruthedev.viewmodel.databinding.ActivityMutableLiveDataBinding

class MutableLiveDataActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMutableLiveDataBinding
    private lateinit var viewModel : MutableLiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mutable_live_data)
        viewModel = ViewModelProvider(this)[MutableLiveDataViewModel::class.java]

        viewModel.textMutableLiveData.observe(this) {
            binding.textView.text = it.toString()
        }
        viewModel.btnMutableLiveData.observe(this){
            binding.button.text = it.toString()
        }
        binding.button.setOnClickListener {
            viewModel.updateText()
        }

    }
}