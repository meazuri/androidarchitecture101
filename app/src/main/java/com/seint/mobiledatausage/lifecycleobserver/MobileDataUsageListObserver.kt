package com.seint.mobiledatausage.lifecycleobserver

import androidx.lifecycle.LifecycleObserver
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent


class MobileDataUsageListObserver(private var mCon: Context?) : LifecycleObserver {
    private val TRACKING_URL = "https://httpbin.org/post"
    private val mOsVersion: String

    init {
        mOsVersion = Build.VERSION.RELEASE
        //mQueue = Volley.newRequestQueue(mCon.getApplicationContext())
        (mCon as AppCompatActivity).getLifecycle().addObserver(this)
    }

//    private fun generateTrackingStringRequest(eventName: String): StringRequest {
//        return object : StringRequest(Request.Method.POST, TRACKING_URL,
//            { response ->
//                // Log.d(TAG, "onResponse() called with: response = [" + response + "]");
//
//            },
//            { error -> Log.d(TAG, "onErrorResponse() called with: error = [$error]") }) {
//            val body: ByteArray
//                @Throws(AuthFailureError::class)
//                get() {
//                    val params = HashMap<String, String>()
//                    params["eventName"] = eventName
//                    params["osVersion"] = mOsVersion
//                    return JSONObject(params).toString().toByteArray()
//                }
//        }
//    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun trackOnCreate() {
        Log.d(TAG, "trackOnCreate() called")
        //mQueue.add(generateTrackingStringRequest("create"))
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun trackOnDestroy() {
        Log.d(TAG, "trackOnDestroy() called")
        (mCon as AppCompatActivity).getLifecycle().removeObserver(this)
        //mQueue.add(generateTrackingStringRequest("destroy"))
        val currentState = (mCon as AppCompatActivity).getLifecycle().getCurrentState()
        mCon = null

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun trackOnStart() {
        Log.d(TAG, "trackOnStart() called")
        //mQueue.add(generateTrackingStringRequest("start"))

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun trackOnResume() {
        Log.d(TAG, "trackOnResume() called")
        //mQueue.add(generateTrackingStringRequest("resume"))

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun trackOnPause() {
        Log.d(TAG, "trackOnPause() called")
        //mQueue.add(generateTrackingStringRequest("pause"))

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun trackOnStop() {
        Log.d(TAG, "trackOnStop() called")
        //mQueue.add(generateTrackingStringRequest("stop"))

    }

    fun trackLocation(lat: Double, lng: Double) {
        Log.d(TAG, "trackLocation() called with: lat = [$lat], lng = [$lng]")
        //mQueue.add(generateTrackingStringRequest("location\t$lat-$lng"))

    }

    companion object {
        private val TAG = MobileDataUsageListObserver::class.java.simpleName
    }
}
