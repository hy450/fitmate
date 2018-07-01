package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

data class BaseResponseModel (
        @SerializedName("ret_code") val ret_code: Int = 0,
        @SerializedName("ret_msg") var ret_msg: String? = null
)