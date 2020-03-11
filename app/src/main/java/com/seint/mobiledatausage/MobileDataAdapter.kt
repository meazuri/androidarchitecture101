package com.seint.mobiledatausage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.seint.mobiledataapi.ui.main.MobileUsageInfo

class MobileDataAdapter(private val context: Context) : RecyclerView.Adapter<MobileDataAdapter.MyViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    private var mobileUsageList: List<MobileUsageInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = layoutInflater.inflate(R.layout.mobileusage_list_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun getItemCount() = mobileUsageList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val course = mobileUsageList[position]
        holder.textViewYear?.text = course.quarter
        holder.textViewData?.text =course.volume_of_mobile_data
        holder.dataPosition = position
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val textViewYear = itemView?.findViewById<TextView?>(R.id.textViewYear)
        var textViewData = itemView?.findViewById<TextView?>(R.id.textViewMobileData)
        var dataPosition = 0
        init {
            itemView?.setOnClickListener {
               // Snackbar.make(it, mobileUsageList[dataPosition].quarter, Snackbar.LENGTH_LONG).show()
            }
        }
    }
    fun setMobileUsageData(mobileUsages: List<MobileUsageInfo>){
        mobileUsageList = mobileUsages
        notifyDataSetChanged()
    }
}