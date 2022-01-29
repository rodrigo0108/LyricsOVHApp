package com.heyoh.appdata.domain.usecase

import com.heyoh.appdata.domain.repository.SongRepository
import com.heyoh.models.Lyrics
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result
import javax.inject.Inject

class GetLyricsSongUseCase @Inject constructor(private val songRepository: SongRepository) {
    suspend operator fun invoke(
        artist: String,
        songName: String
    ): Result<Lyrics, Failure> = songRepository.getLyrics(artist, songName)
}