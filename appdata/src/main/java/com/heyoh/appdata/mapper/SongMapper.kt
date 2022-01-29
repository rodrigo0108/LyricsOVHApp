package com.heyoh.appdata.mapper

import com.heyoh.models.Lyrics
import com.heyoh.models.SuggestedSong
import com.heyoh.models.response.LyricsResponse
import com.heyoh.models.response.SuggestedSongDataResponse

fun SuggestedSongDataResponse.toDomain() = data.map {
    SuggestedSong(
        id = it.id,
        songName = it.title_short,
        imageURL = it.artist.picture_medium,
        artistName = it.artist.name
    )
}

fun LyricsResponse.toDomain() = Lyrics(
    content = lyrics
)