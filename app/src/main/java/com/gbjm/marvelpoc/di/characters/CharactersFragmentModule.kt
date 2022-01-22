package com.gbjm.marvelpoc.di.characters

import com.gbjm.core.di.annotations.FragmentScoped
import com.gbjm.detail.ui.CharacterDetailFragment
import com.gbjm.characters.ui.CharacterListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class CharactersFragmentModule {

    @FragmentScoped @ContributesAndroidInjector
    internal abstract fun contributeCharacterListFragment(): CharacterListFragment

}
