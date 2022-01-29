package com.heyoh.lyricsovhapp.main.suggestedSong

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heyoh.appdata.domain.usecase.GetSuggestedSongUseCase
import com.heyoh.models.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getSuggestedSongUseCase: GetSuggestedSongUseCase
) : ViewModel() {

    private val _model = MutableLiveData<SearchModel>()
    val model: LiveData<SearchModel> get() = _model

    fun getSuggestedSongs(searchTerm: String) {

        viewModelScope.launch {

            val result = withContext(Dispatchers.IO) {
                getSuggestedSongUseCase.invoke(searchTerm)
            }
            if (result is Result.Success) {
                _model.value = SearchModel.Success(result.value)
            } else {
                _model.value = SearchModel.Error
            }

        }
    }

}