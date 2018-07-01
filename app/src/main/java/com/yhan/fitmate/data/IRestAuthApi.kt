package com.yhan.fitmate.data

import com.yhan.fitmate.datamodel.RegisterCenterMemberRsp
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IRestAuthApi {
    companion object {
        private const val PARAM_AUTHNUM = "auth_num"
        private const val PARAM_PHONE = "phone"
    }

    @FormUrlEncoded
    @POST("users/centers/smsauth/register")
    fun registerCenterMember(@Field(PARAM_AUTHNUM) auth_num: String, @Field(PARAM_PHONE) phone: String): Call<RegisterCenterMemberRsp>


}