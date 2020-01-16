package com.handh.testapp.model

import com.google.gson.annotations.SerializedName

class Main {

    @SerializedName("temp")
    val temp = 0f
    @SerializedName("pressure")
    val pressure: Long = 0
    @SerializedName("humidity")
    val humidity: Long = 0
    @SerializedName("temp_min")
    val tempMin = 0.0
    @SerializedName("temp_max")
    val tempMax = 0.0

}