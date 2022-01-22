package com.gbjm.marvelpoc.di.detail

import androidx.lifecycle.ViewModel
import com.gbjm.detail.ui.CharacterDetailViewModel
import com.gbjm.marvelpoc.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [CharacterDetailFragmentModule::class])
internal abstract class CharacterDetailModule {

    /**
    The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [CharacterDetailViewModel] class.
     */
    @Binds
    @IntoMap
    @ViewModelKey(CharacterDetailViewModel::class)
    abstract fun bindCharacterDetailViewModel(viewModel: CharacterDetailViewModel): ViewModel
}
