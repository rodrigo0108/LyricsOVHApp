package com.heyoh.appdata.data.source.remote

import com.heyoh.appdata.data.datastore.SongDataStore
import com.heyoh.appdata.data.service.SongService
import com.heyoh.appdata.mapper.toDomain
import com.heyoh.models.Lyrics
import com.heyoh.models.SuggestedSong
import com.heyoh.models.response.ApiErrorResponse
import com.heyoh.models.result.Failure
import com.heyoh.models.result.Result
import com.squareup.moshi.Moshi
import java.lang.Exception
import javax.inject.Inject

@Suppress("BlockingMethodInNonBlockingContext")
class SongDataStoreImpl @Inject constructor(
    private val moshi: Moshi,
    private val songService: SongService
) : SongDataStore {
    override suspend fun getSuggestedSongs(searchTerm: String): Result<List<SuggestedSong>, Failure> {
        return try {
            val result = songService.getSuggestedSongs(searchTerm)

            if (result.isSuccessful && result.body() != null) {
                Result.Success(result.body()!!.toDomain())
            } else {
                val errorAdapter = moshi.adapter(ApiErrorResponse::class.java)
                val apiErrorResponse = errorAdapter.fromJson(result.errorBody()?.string() ?: "")
                return if (apiErrorResponse != null) {
                    Result.Error(Failure.ClientError(apiErrorResponse))
                } else {
                    Result.Error(Failure.Unexpected)
                }
            }
        } catch (ex: Exception) {
            Result.Error(Failure.Unexpected)
        }
    }

    override suspend fun getLyrics(artist: String, song: String): Result<Lyrics, Failure> {
        return try {
            val result = songService.getLyrics(artist, song)

            if (result.isSuccessful && result.body() != null) {
                Result.Success(result.body()!!.toDomain())
            } else {
                val errorAdapter = moshi.adapter(ApiErrorResponse::class.java)
                val apiErrorResponse = errorAdapter.fromJson(result.errorBody()?.string() ?: "")
                return if (apiErrorResponse != null) {
                    Result.Error(Failure.ClientError(apiErrorResponse))
                } else {
                    Result.Error(Failure.Unexpected)
                }
            }
        } catch (ex: Exception) {
            Result.Error(Failure.Unexpected)
        }
    }
}