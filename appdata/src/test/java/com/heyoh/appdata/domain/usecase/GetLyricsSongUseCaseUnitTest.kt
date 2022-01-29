package com.heyoh.appdata.domain.usecase

import com.heyoh.models.result.Result
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mockito.verify

@RunWith(MockitoJUnitRunner::class)
class GetLyricsSongUseCaseUnitTest {

    @Mock
    private lateinit var getLyricsSongUseCase: GetLyricsSongUseCase

    @Test
    fun getSuccessfulLyricsSong() = runBlocking {

        val result = getLyricsSongUseCase.invoke("", "")

        if (result is Result.Success){
            verify(result).value
        }
    }
}