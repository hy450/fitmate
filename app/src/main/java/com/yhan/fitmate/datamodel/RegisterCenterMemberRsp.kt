package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

data class RegisterCenterMemberRsp(
        @SerializedName("ret_code") val ret_code: Int = 0,
        @SerializedName("ret_msg") val ret_msg: String? = null,
        @SerializedName("session_key") val session_key: String? = null,
        @SerializedName("userinfo") val userinfo: UserMemberInfo? = null,
        @SerializedName("is_new")val is_new: Char? = null
){
    companion object {
        fun empty() = RegisterCenterMemberRsp()
    }
}