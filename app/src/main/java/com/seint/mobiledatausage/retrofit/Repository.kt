package com.seint.mobiledatausage.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.seint.mobiledataapi.ui.main.MobileModel
import com.seint.mobiledataapi.ui.main.MobileUsageInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor



class ProjectRepository private constructor() {
    private val retrofitService: RetrofitService
    val HTTPS_API_URL = "https://data.gov.sg/"


    init {
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        // add your other interceptors …
        // add logging as last interceptor
        httpClient.addInterceptor(logging)
        //TODO this retrofitService instance will be injected using Dagger in part #2 ...
        val retrofit = Retrofit.Builder()
            .baseUrl(HTTPS_API_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofitService = retrofit.create(RetrofitService::class.java!!)
    }

    fun dataStoreSearch(): MutableLiveData<List<MobileUsageInfo>> {
        var data = MutableLiveData<List<MobileUsageInfo>>()

        retrofitService.dataStoreSearch().enqueue(object : Callback<MobileModel.MobileDataResponse> {
            override fun onResponse(call: Call<MobileModel.MobileDataResponse>, response: Response<MobileModel.MobileDataResponse>) {
                val mobileDataResponse =  response.body()
                data.value = mobileDataResponse?.result?.records!!
            }

            override fun onFailure(call: Call<MobileModel.MobileDataResponse>, t: Throwable) {
                // TODO better error handling in part #2 ...
                data.setValue(null)
            }
        })

        return data
    }



    private fun simulateDelay() {
        try {
            Thread.sleep(10)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    companion object {
        private var projectRepository: ProjectRepository? = null

        //TODO No need to implement this singleton in Part #2 since Dagger will handle it ...
        val instance: ProjectRepository
            @Synchronized get() {
                if (projectRepository == null) {
                    if (projectRepository == null) {
                        projectRepository = ProjectRepository()
                    }
                }
                return projectRepository as ProjectRepository
            }
    }
}

