package com.seint.mobiledatausage.retrofit

import com.seint.mobiledataapi.ui.main.MobileModel
import retrofit2.Call
import retrofit2.http.GET


interface  RetrofitService {


    @GET("api/action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    fun dataStoreSearch( ): Call<MobileModel.MobileDataResponse>
}