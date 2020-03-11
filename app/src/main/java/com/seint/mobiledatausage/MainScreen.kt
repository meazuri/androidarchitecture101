package com.seint.mobiledatausage

import com.seint.mobiledataapi.ui.main.MobileUsageInfo

interface MainScreen {
    abstract fun updateData(data: List<MobileUsageInfo>)
    abstract fun setError(msg: String)
}