package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

data class GetCenterSrchResultList(
        @SerializedName("ret_code") val ret_code: Int = 0,
        @SerializedName("ret_msg") var ret_msg: String? = null,
        @SerializedName("centerList")
        var centerList: List<CenterInfo>? = null,
        @SerializedName("paginationInfo")
        var paginationInfo: PageIndexModel? = null
) {
}