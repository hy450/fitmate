package com.yhan.fitmate.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthService
@Inject constructor(retrofit: Retrofit) : IRestAuthApi{

    private val authApi by lazy { retrofit.create(IRestAuthApi::class.java) }

    override fun registerCenterMember(auth_num: String, phone: String) = authApi.registerCenterMember(auth_num,phone)
}