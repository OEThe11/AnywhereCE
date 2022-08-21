package com.ocode.anywherece.di

import android.content.Context
import androidx.room.Room
import com.ocode.anywherece.Constants.BASE_URL
import com.ocode.anywherece.data.AnywhereDao
import com.ocode.anywherece.data.AnywhereDatabase
import com.ocode.anywherece.network.AnywhereAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideAnywhereDao(anywhereDatabase: AnywhereDatabase): AnywhereDao =
        anywhereDatabase.anywhereDao()

    @Singleton
    @Provides
    fun provideAnywhereDatabase(@ApplicationContext context: Context): AnywhereDatabase =
        Room.databaseBuilder(
            context,
            AnywhereDatabase::class.java,
            "Anywhere"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideAnywhereApi(): AnywhereAPI {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(AnywhereAPI::class.java)
    }

}