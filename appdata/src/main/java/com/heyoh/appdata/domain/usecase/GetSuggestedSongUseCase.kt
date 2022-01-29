package com.heyoh.appdata.domain.usecase

import com.heyoh.appdata.domain.repository.SongRepository
import com.heyoh.models.SuggestedSong
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result
import javax.inject.Inject

class GetSuggestedSongUseCase @Inject constructor(private val songRepository: SongRepository) {
    suspend operator fun invoke(
        searchTerm: String
    ): Result<List<SuggestedSong>, Failure> = songRepository.getSuggestedSongs(searchTerm)
}