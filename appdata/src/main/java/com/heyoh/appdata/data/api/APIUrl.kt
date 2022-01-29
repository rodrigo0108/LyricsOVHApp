package com.heyoh.appdata.data.api

object APIUrl {
    const val BASE = "https://api.lyrics.ovh"
    const val SEARCH_TERM = "SEARCH_TERM"
    const val ARTIST = "ARTIST"
    const val SONG = "SONG"
    const val SUGGESTED_SONG = "/suggest/{$SEARCH_TERM}"
    const val SEARCH_LYRICS = "/v1/{$ARTIST}/{$SONG}"
}