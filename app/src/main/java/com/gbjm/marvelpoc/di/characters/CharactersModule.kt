package com.gbjm.marvelpoc.di.characters

import androidx.lifecycle.ViewModel
import com.gbjm.characters.ui.CharacterListViewModel
import com.gbjm.marvelpoc.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [CharactersFragmentModule::class])
internal abstract class CharactersModule {

    /**
    The ViewModels are created by Dagger in a map. Via the @ViewModelKey, we define that we
     * want to get a [CharacterListViewModel] class.
     */
    @Binds @IntoMap @ViewModelKey(CharacterListViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: CharacterListViewModel): ViewModel
}
