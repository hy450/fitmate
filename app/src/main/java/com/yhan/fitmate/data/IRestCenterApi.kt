package com.yhan.fitmate.data

import com.yhan.fitmate.datamodel.GetCenterSrchResultList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IRestCenterApi {

    @GET("centers/search/{searchType}")
    fun getCenterSrchResultList(@Path("searchType") searchType: String, @Query("searchKeyword") keyword: String, @Query("pageIndex") pageIndex: Int): Call<GetCenterSrchResultList>
}