package com.heyoh.appdata.di

import com.heyoh.appdata.data.datastore.SongDataStore
import com.heyoh.appdata.data.repository.SongRepositoryImpl
import com.heyoh.appdata.data.service.SongService
import com.heyoh.appdata.data.source.remote.SongDataStoreImpl
import com.heyoh.appdata.domain.repository.SongRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SongModule {
    @Singleton
    @Provides
    fun provideSongRepository(songRepositoryImpl: SongRepositoryImpl): SongRepository{
        return songRepositoryImpl
    }
    @Singleton
    @Provides
    fun provideSongDataStore(songDataStoreImpl: SongDataStoreImpl): SongDataStore{
        return songDataStoreImpl
    }
    @Singleton
    @Provides
    fun provideSongApiClient(retrofit: Retrofit): SongService {
        return retrofit.create(SongService::class.java)
    }
}