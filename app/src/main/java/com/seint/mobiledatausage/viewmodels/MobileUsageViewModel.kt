package com.seint.mobiledatausage.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.seint.mobiledataapi.ui.main.MobileUsageInfo
import com.seint.mobiledatausage.retrofit.ProjectRepository

class MobileUsageViewModel : ViewModel() {

    private var mobileDataUsageListObservable: LiveData<List<MobileUsageInfo>> = MutableLiveData<List<MobileUsageInfo>>()

    init {
        mobileDataUsageListObservable = ProjectRepository.instance.dataStoreSearch()
    }

    fun getMobileDataUsageListObservable(): LiveData<List<MobileUsageInfo>> {
        return mobileDataUsageListObservable
    }


}