package com.heyoh.appdata.domain.repository

import com.heyoh.models.Lyrics
import com.heyoh.models.SuggestedSong
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result

interface SongRepository {
    suspend fun getSuggestedSongs(searchTerm: String): Result<List<SuggestedSong>, Failure>
    suspend fun getLyrics(
        artist: String,
        song: String
    ): Result<Lyrics, Failure>
}