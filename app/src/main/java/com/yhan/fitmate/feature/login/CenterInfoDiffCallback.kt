package com.yhan.fitmate.feature.login

import androidx.recyclerview.widget.DiffUtil
import com.yhan.fitmate.datamodel.CenterInfo

class CenterInfoDiffCallback(val oldItems: List<CenterInfo>, val newItems: List<CenterInfo> ) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    = oldItems[oldItemPosition].gym_cd == newItems[newItemPosition].gym_cd



    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean
    = oldItems[oldItemPosition] == newItems[newItemPosition]

}