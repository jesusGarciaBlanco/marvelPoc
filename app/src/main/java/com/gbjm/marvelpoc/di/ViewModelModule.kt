package com.gbjm.marvelpoc.di

import androidx.lifecycle.ViewModelProvider
import com.gbjm.core.architecture.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory):
            ViewModelProvider.Factory
}