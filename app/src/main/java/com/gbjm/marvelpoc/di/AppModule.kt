package com.gbjm.marvelpoc.di

import android.content.Context
import com.gbjm.marvelpoc.MarvelApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * App level dependencies
 */
@Module
open class AppModule{

    @Provides
    @Singleton
    fun provideApplication(application: MarvelApplication): Context {
        return application.applicationContext
    }
}