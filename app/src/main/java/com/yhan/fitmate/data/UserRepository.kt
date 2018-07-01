package com.yhan.fitmate.data

import com.yhan.fitmate.core.exception.Failure
import com.yhan.fitmate.core.exception.Failure.ServerError
import com.yhan.fitmate.core.functional.Either
import com.yhan.fitmate.core.functional.Either.Left
import com.yhan.fitmate.core.functional.Either.Right
import com.yhan.fitmate.core.platform.NetworkHandler
import com.yhan.fitmate.datamodel.RegisterCenterMemberRsp
import com.yhan.fitmate.entity.UserInfo
import retrofit2.Call
import javax.inject.Inject

/**
 * 사용자 정보
 */
interface UserRepository {
    // 사용자 인증
    fun logIn(auth_num:String, phone:String): Either<Failure, UserInfo>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: AuthService ) : UserRepository {

        override fun logIn(auth_num:String, phone:String): Either<Failure, UserInfo> {
            return when(networkHandler.isConnected) {
                true -> request(service.registerCenterMember(auth_num,phone), {
                    if( it.ret_code == 200 ) {
                        //TODO :: sesstion key 저장
                        UserInfo( it.userinfo!!.user_id, it.userinfo.name)
                    }else {
                        UserInfo()
                    }

                    }, RegisterCenterMemberRsp.empty())
                false, null -> Left(Failure.NetworkConnection())
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform((response.body() ?: default)))
                    false -> Left(ServerError())
                }
            } catch (exception: Throwable) {
                Left(ServerError())
            }
        }

    }



}