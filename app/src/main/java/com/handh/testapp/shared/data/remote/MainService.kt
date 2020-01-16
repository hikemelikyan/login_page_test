package com.handh.testapp.shared.data.remote

import androidx.lifecycle.MutableLiveData
import com.handh.testapp.shared.configs.AppConstants
import com.handh.testapp.shared.data.remote.root.BaseService

class MainService(private val mService: IMainService) : BaseService() {

    suspend fun testCall(lat: Double, lng: Double, units: String, liveData: MutableLiveData<Any>) {
        autoCallAsync({
            mService.testCallAsync(
                lat.toString(),
                lng.toString(),
                AppConstants.APP_ID,
                units
            )
        }, liveData)
    }
}