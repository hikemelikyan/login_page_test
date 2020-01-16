package com.handh.testapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.handh.testapp.viewmodel.root.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : BaseViewModel(application) {

    val weatherDetailsLiveData: MutableLiveData<Any> = MutableLiveData()

    fun getWeatherDetails(lat: Double, lng: Double, units: String) {
        scope.launch {
            mService.testCall(lat, lng, units, weatherDetailsLiveData)
        }
    }

}