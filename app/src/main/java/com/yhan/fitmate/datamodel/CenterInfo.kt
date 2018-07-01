package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

data class CenterInfo(
        @SerializedName("gym_cd")
        val gym_cd: String? = null,
        @SerializedName("gym_name")
        val gym_name: String? =null,
        @SerializedName("gym_tel")
        val gym_tel: String? = null,
        @SerializedName("gym_address")
        val gym_address: String? = null,
        @SerializedName("gym_ceo_name")
        val gym_ceo_name: String? = null,
        @SerializedName("gym_img_list")
        val gym_img_list: List<String>? = null,
        @SerializedName("gym_logo_img")
        val gym_logo_img: String? = null,
        @SerializedName("gym_usage_time")
        val gym_usage_time: String? = null,
        @SerializedName("gym_center_theme")
        val gym_center_theme: String? = null,
        @SerializedName("gym_promotion_img_list")
        val gym_promotion_img_list: List<String>? = null,
        @SerializedName("gx_can_reserv_app") // 모바일에서 예약 지원이 가능한가? 'Y'/ 'N'
        val gx_can_reserv_app: Char? = null,
        @SerializedName("gx_can_reserv_loc") // 센터에 출입 후 예약이 가능한가? 'Y' / 'N'
        val gx_can_reserv_loc: Char? = null,
        @SerializedName("gx_can_reserv_start") // 예약 가능한 시작 시간 ( 수업시작 몇분전 ? 분단위 )
        val gx_can_reserv_start: Int? = null,
        @SerializedName("gx_can_reserv_end") // 예약 가능한 시작 시간 ( 수업시작 몇분전 ? 분단위 )
        val gx_can_reserv_end: Int? = null // 예약이 종료되는 시간 ( 수업시작 몇분전 ? 분단위 )
) {
}