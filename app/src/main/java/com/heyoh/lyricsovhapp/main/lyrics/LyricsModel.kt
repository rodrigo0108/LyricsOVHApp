package com.heyoh.lyricsovhapp.main.lyrics

import com.heyoh.models.Lyrics

sealed class LyricsModel {
    data class Success(
        val lyricsContent: Lyrics) : LyricsModel()
    object Error : LyricsModel()
}