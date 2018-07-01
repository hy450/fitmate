package com.yhan.fitmate.domain

import com.yhan.fitmate.core.exception.Failure
import com.yhan.fitmate.core.functional.Either
import com.yhan.fitmate.core.interactor.UseCase
import com.yhan.fitmate.data.UserRepository
import com.yhan.fitmate.entity.UserInfo
import javax.inject.Inject

class GetUser
@Inject constructor(private val userRepository: UserRepository) : UseCase<UserInfo,HashMap<String,String>>() {
    override suspend fun run(params: HashMap<String, String>): Either<Failure, UserInfo>
        = userRepository.logIn(params["auth_num"]!!,params["phone"]!!)
}