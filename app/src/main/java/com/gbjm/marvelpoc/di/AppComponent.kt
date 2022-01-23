package com.gbjm.marvelpoc.di

import com.gbjm.marvelpoc.MarvelApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        AppModule::class,
        DomainModule::class
    ]
)

interface AppComponent : AndroidInjector<MarvelApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: MarvelApplication): AppComponent
    }
}