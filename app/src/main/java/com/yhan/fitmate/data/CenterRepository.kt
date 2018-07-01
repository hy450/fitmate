package com.yhan.fitmate.data

import com.yhan.fitmate.core.exception.Failure
import com.yhan.fitmate.core.functional.Either
import com.yhan.fitmate.core.functional.Either.Left
import com.yhan.fitmate.core.functional.Either.Right
import com.yhan.fitmate.core.platform.NetworkHandler
import com.yhan.fitmate.datamodel.CenterInfo
import retrofit2.Call
import javax.inject.Inject

interface CenterRepository {

    fun searchCenter(keyword: String, pageIdx: Int): Either<Failure, List<CenterInfo>>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: CenterService ) : CenterRepository {
        override fun searchCenter(keyword: String, pageIdx: Int): Either<Failure, List<CenterInfo>> {
            return when(networkHandler.isConnected) {
                true -> request( service.getCenterSrchResultList("nm", keyword, pageIdx)) {
                    if( it.ret_code == 200) it.centerList ?: emptyList()
                    else emptyList()
                }
                false,null -> Left(Failure.NetworkConnection())
            }

        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> {
                        response.body()?.let {
                            Right(transform(it))
                        } ?:Left(Failure.ServerError())
                    }
                    false -> Left(Failure.ServerError())
                }
            } catch (exception: Throwable) {
                Left(Failure.ServerError())
            }
        }
    }
}