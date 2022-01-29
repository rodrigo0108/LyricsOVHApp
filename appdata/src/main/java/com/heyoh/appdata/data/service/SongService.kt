package com.heyoh.appdata.data.service

import com.heyoh.appdata.data.api.APIUrl
import com.heyoh.appdata.data.api.APIUrl.ARTIST
import com.heyoh.appdata.data.api.APIUrl.SEARCH_TERM
import com.heyoh.appdata.data.api.APIUrl.SONG
import com.heyoh.models.response.LyricsResponse
import com.heyoh.models.response.SuggestedSongDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SongService {

    @GET(APIUrl.SUGGESTED_SONG)
    suspend fun getSuggestedSongs(
        @Path(SEARCH_TERM) searchTerm: String
    ): Response<SuggestedSongDataResponse>

    @GET(APIUrl.SEARCH_LYRICS)
    suspend fun getLyrics(
        @Path(ARTIST) artist: String,
        @Path(SONG) song: String
    ): Response<LyricsResponse>

}