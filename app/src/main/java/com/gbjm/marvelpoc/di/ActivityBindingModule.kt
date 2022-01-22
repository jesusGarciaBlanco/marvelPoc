package com.gbjm.marvelpoc.di

import com.gbjm.core.di.annotations.ActivityScoped
import com.gbjm.core.di.annotations.FragmentScoped
import com.gbjm.core.ui.MainActivity
import com.gbjm.core.ui.StartFragment
import com.gbjm.marvelpoc.di.characters.CharactersModule
import com.gbjm.marvelpoc.di.detail.CharacterDetailModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [
        CharactersModule::class,
        CharacterDetailModule::class])

    internal abstract fun bindMainActivity(): MainActivity

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeStartFragment(): StartFragment

}
