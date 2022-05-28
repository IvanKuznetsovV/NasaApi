package com.ivankuznetsov.nasaapi.di

import android.content.Context
import com.ivankuznetsov.nasaapi.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApp(@ApplicationContext app: Context): BaseApplication{
        return app as BaseApplication
    }
}