package com.yhan.fitmate.feature.login

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yhan.fitmate.R
import com.yhan.fitmate.core.extension.debug
import com.yhan.fitmate.datamodel.CenterInfo

class CenterSrchResultRecyclerAdapter(private val context: Context, private val onClick: (CenterInfo) -> Unit )
    : RecyclerView.Adapter<CenterSrchResultRecyclerAdapter.ViewHolder>() {

    var centers = mutableListOf<CenterInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.center_srch_list_item,parent,false)
        return CenterSrchResultRecyclerAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int = centers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val centerName = holder.itemView.findViewById<TextView>(R.id.centerName)
        val centerAddress = holder.itemView.findViewById<TextView>(R.id.centerAddress)

        centerName.text = centers[holder.adapterPosition].gym_name
        centerAddress.text = centers[holder.adapterPosition].gym_address

        debug("position : ${position}")

        holder.itemView.setOnClickListener { onClick(centers[holder.adapterPosition]) }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}