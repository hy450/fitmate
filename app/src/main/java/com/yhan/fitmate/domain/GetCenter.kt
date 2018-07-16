package com.yhan.fitmate.domain

import com.yhan.fitmate.core.exception.Failure
import com.yhan.fitmate.core.functional.Either
import com.yhan.fitmate.core.interactor.UseCase
import com.yhan.fitmate.data.CenterRepository
import com.yhan.fitmate.datamodel.CenterInfo
import javax.inject.Inject

class GetCenter
@Inject constructor(private val centerRepository: CenterRepository) : UseCase<List<CenterInfo>,GetCenter.Params>() {
    override suspend fun run(params: Params): Either<Failure, List<CenterInfo>>
    = centerRepository.searchCenter(params.keyword, params.pageIdx)

    data class Params(val keyword: String, val pageIdx: Int)
}