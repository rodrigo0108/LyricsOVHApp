package com.heyoh.lyricsovhapp.main.suggestedSong

import com.heyoh.models.SuggestedSong

sealed class SearchModel  {
    data class Success(
        val listSongs: List<SuggestedSong>) : SearchModel()
    object Error : SearchModel()
}