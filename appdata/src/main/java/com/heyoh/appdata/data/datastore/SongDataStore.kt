package com.heyoh.appdata.data.datastore

import com.heyoh.models.Lyrics
import com.heyoh.models.SuggestedSong
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result
interface SongDataStore {
    suspend fun getSuggestedSongs(searchTerm: String): Result<List<SuggestedSong>, Failure>
    suspend fun getLyrics(
        artist: String,
        song: String
    ): Result<Lyrics, Failure>
}