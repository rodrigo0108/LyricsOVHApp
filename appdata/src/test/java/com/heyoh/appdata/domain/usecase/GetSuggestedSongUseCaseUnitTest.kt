package com.heyoh.appdata.domain.usecase

import com.heyoh.models.result.Result
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSuggestedSongUseCaseUnitTest {

    @Mock
    private lateinit var getSuggestedSongUseCase: GetSuggestedSongUseCase

    @Test
    fun getSuccessfulLyricsSong() = runBlocking {

        val result = getSuggestedSongUseCase.invoke("")

        if (result is Result.Success){
            Mockito.verify(result).value
        }
    }
}