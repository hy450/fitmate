package com.yhan.fitmate.data

import com.yhan.fitmate.datamodel.GetCenterSrchResultList
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CenterService
@Inject constructor(retrofit: Retrofit) : IRestCenterApi {

    private val api by lazy { retrofit.create(IRestCenterApi::class.java) }

    override fun getCenterSrchResultList(searchType: String, keyword: String, pageIndex: Int): Call<GetCenterSrchResultList>
    = api.getCenterSrchResultList(searchType,keyword,pageIndex)
}