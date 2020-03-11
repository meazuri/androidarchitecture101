package com.seint.mobiledatausage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seint.mobiledataapi.ui.main.MobileUsageInfo
import com.seint.mobiledatausage.lifecycleobserver.MobileDataUsageListObserver
import com.seint.mobiledatausage.viewmodels.MobileUsageViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private lateinit var mAdapter: MobileDataAdapter
    lateinit var mobileUsageViewModel :MobileUsageViewModel
    private var mLastFetchedDataTimeStamp: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         mAdapter = MobileDataAdapter(this)

        val lm = LinearLayoutManager(this)
        lm.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = lm
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled =false

        mobileUsageViewModel = ViewModelProviders.of(this).get(MobileUsageViewModel::class.java)

        mobileUsageViewModel.getMobileDataUsageListObservable().observe(this, Observer {

            if(it != null){
                mAdapter.setMobileUsageData(it)
                mAdapter.notifyDataSetChanged()
            }
        })

       // mViewModel.getErrorUpdates().observe(this, errorObserver)
    }
}
