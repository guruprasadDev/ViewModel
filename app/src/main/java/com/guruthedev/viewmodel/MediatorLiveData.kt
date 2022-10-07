package com.guruthedev.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.guruthedev.viewmodel.databinding.ActivityMediatorLiveDataBinding

class MediatorLiveData : AppCompatActivity() {
    private lateinit var binding:ActivityMediatorLiveDataBinding
    private var mFirstCounter = 0
    private var mSecondCounter = 0

    private var mFirstCounterMutableLive : MutableLiveData<Int> = MutableLiveData()
    private var mSecondCounterMutableLiveData :MutableLiveData<Int> = MutableLiveData()
    private val mMediatorLiveData : MediatorLiveData<Int> = MediatorLiveData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mediator_live_data)

        binding.btnFirstCounter.setOnClickListener {
            mFirstCounter++
            mFirstCounterMutableLive.value = mFirstCounter
        }
        binding.btnSecondCounter.setOnClickListener {
            mSecondCounter++
            mSecondCounterMutableLiveData.value = mSecondCounter
        }
        mMediatorLiveData.addSource(mFirstCounterMutableLive){
            mMediatorLiveData.value = it
        }
        mMediatorLiveData.addSource(mSecondCounterMutableLiveData){
            mMediatorLiveData.value = it
        }

        mMediatorLiveData.observe(this){
                binding.tvCounter.text = it.toString()
            }
    }
}