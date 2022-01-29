package com.heyoh.appdata.data.repository

import com.heyoh.appdata.data.datastore.SongDataStore
import com.heyoh.appdata.domain.repository.SongRepository
import com.heyoh.models.Lyrics
import com.heyoh.models.SuggestedSong
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(private val songDataStore: SongDataStore) :
    SongRepository {
    override suspend fun getSuggestedSongs(searchTerm: String): Result<List<SuggestedSong>, Failure> =
        songDataStore.getSuggestedSongs(searchTerm)

    override suspend fun getLyrics(artist: String, song: String): Result<Lyrics, Failure> =
        songDataStore.getLyrics(artist, song)
}