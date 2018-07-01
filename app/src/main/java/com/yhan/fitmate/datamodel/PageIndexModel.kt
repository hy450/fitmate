package com.yhan.fitmate.datamodel

import com.google.gson.annotations.SerializedName

class PageIndexModel(
        @SerializedName("currentPageNo")
        val currentPageNo: Int = 0,
        @SerializedName("recordCountPerPage")
        val recordCountPerPage: Int = 0,
        @SerializedName("pageSize")
        val pageSize: Int = 0,
        @SerializedName("totalRecordCount")
        val totalRecordCount: Int = 0,
        @SerializedName("totalPageCount")
        val totalPageCount: Int = 0,
        @SerializedName("firstPageNoOnPageList")
        val firstPageNoOnPageList: Int = 0,
        @SerializedName("lastPageNoOnPageList")
        val lastPageNoOnPageList: Int = 0,
        @SerializedName("firstRecordIndex")
        val firstRecordIndex: Int = 0,
        @SerializedName("lastRecordIndex")
        val lastRecordIndex: Int = 0,
        @SerializedName("firstPageNo")
        val firstPageNo: Int = 0,
        @SerializedName("lastPageNo")
        val lastPageNo: Int = 0
) {
}