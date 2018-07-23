package com.yhan.fitmate

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.yhan.fitmate.core.functional.Either
import com.yhan.fitmate.data.CenterRepository
import com.yhan.fitmate.datamodel.CenterInfo
import com.yhan.fitmate.domain.GetCenter
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetCenterTest : UnitTest(){

    private lateinit var getCenter: GetCenter

    @Mock private lateinit var centerRepository: CenterRepository

    val centerList = listOf (
            CenterInfo("1","SC_1","0101234567"),
            CenterInfo("2","SC_2","0103456767")
    )

    @Before fun setUp() {
        getCenter = GetCenter(centerRepository)
        given { centerRepository.searchCenter("SC",1) }.willReturn(Either.Right(centerList))
    }

    @Test fun `should get return center info`() {
        //var cetnerList: List<CenterInfo>
        runBlocking {

            var either = getCenter.run(GetCenter.Params("SC", 1))
            Assert.assertEquals( true, either.isRight )
            Assert.assertEquals(2,(either as Either.Right).b.size)
        }

        verify( centerRepository).searchCenter("SC",1)





    }
}