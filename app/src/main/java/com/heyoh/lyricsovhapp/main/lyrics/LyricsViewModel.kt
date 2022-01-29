package com.heyoh.lyricsovhapp.main.lyrics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heyoh.appdata.domain.usecase.GetLyricsSongUseCase
import com.heyoh.models.SuggestedSong
import com.heyoh.models.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LyricsViewModel @Inject constructor(
    private val getLyricsSongUseCase: GetLyricsSongUseCase
): ViewModel() {

    private val _model = MutableLiveData<LyricsModel>()
    val model: LiveData<LyricsModel> get() = _model

    fun getLyricsSong(suggestedSong: SuggestedSong){
        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                getLyricsSongUseCase.invoke(suggestedSong.artistName, suggestedSong.songName)
            }
            if (result is Result.Success) {
                _model.value = LyricsModel.Success(result.value)
            } else {
                _model.value = LyricsModel.Error
            }

        }
    }
}