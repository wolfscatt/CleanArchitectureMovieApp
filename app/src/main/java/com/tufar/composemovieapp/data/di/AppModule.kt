package com.tufar.composemovieapp.data.di

import com.tufar.composemovieapp.data.remote.MovieApi
import com.tufar.composemovieapp.data.repository.MovieRepoImpl
import com.tufar.composemovieapp.domain.repository.MovieRepo
import com.tufar.composemovieapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieApi() : MovieApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieRepo(api : MovieApi) : MovieRepo{
        return MovieRepoImpl(api)
    }
}