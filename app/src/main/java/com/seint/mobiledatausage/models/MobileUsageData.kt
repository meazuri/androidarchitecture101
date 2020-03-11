package com.seint.mobiledataapi.ui.main

import androidx.lifecycle.MutableLiveData
import com.google.gson.annotations.SerializedName


data class MobileUsageInfo (@SerializedName("_id")var id: String, @SerializedName("quarter")var quarter: String, @SerializedName("volume_of_mobile_data")var volume_of_mobile_data:String) {
    override fun toString(): String {
        return quarter
    }
}

object MobileModel{

    data class MobileDataResponse(@SerializedName("help") var help: String, var success:Boolean,@SerializedName("result") var result: Result)
    data class Result(@SerializedName("resource_id") var resource_id : String, @SerializedName ("records") var records: List<MobileUsageInfo>, var total: Int ){




    }

}

