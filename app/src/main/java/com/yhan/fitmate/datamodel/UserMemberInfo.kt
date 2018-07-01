package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName
import com.yhan.fitmate.entity.UserInfo

data class UserMemberInfo(
        @SerializedName("user_cd") val user_cd: String? = null,
        @SerializedName("session_key") val session_key: String? = null,     // 임시로 발급받는 키
        @SerializedName("user_id") val user_id: String? = null,
        @SerializedName("kakao_id") val kakao_id: String? = null,
        @SerializedName("name") val name: String? = null,                   // 이름
        @SerializedName("phone") val phone: String? = null,
        @SerializedName("phone_auth") val phone_auth: String = "0",         // 0 : no , 1:yes // 폰 인증 여부
        @SerializedName("address") val address: String? = null,
        @SerializedName("zip_cd") val zip_cd: String? = null,
        @SerializedName("gender") val gender: Char? = null,                 // 'F', 'M'
        @SerializedName("profileimg") val profileimg: String? = null,       //profileimg path
        @SerializedName("birthday") val birthday: String? = null,           // yyyy-MM-dd
        @SerializedName("auth_type") val auth_type: Int? = null,            // 회원인증 타입    center member ( 0x01 )  id&password ( 0x02 ) , kakao ( 0x04 )
        @SerializedName("kakao_session_key") val kakao_session_key: String? = null,
        @SerializedName("device_id") val device_id: String? = null,         // 모바일 PUSH devID
        @SerializedName("food_config") val food_config: FoodConfig? = null,
        @SerializedName("height") val height: Double? = null,
        @SerializedName("email") val email: String? = null
)
{
    fun toUserInfo() = UserInfo(user_cd, name)
}