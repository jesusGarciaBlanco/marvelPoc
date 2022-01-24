# marvelPoc
marvel company code test

poc marvel

This app is a solution designed with MVVM arquitecture, kotlin language, Retrofit 2 with okHttp 3
as a communication client, Dagger 2 for dependency injection, coroutines to communicate viewModels
with the domain layer (through Use Cases) and LiveData (observer pattern) to communicate Views
(android Fragments and Activities) with ViewModels, with this pattern I remove the need of the
viewModel to know the implementation of the view and navigation component for navigate between fragments.
I use "mappers" to transform domain entities in UI entitites.

Testing: Using Espresso to implement instrumented tests. the tests are located to app module into
the 'src/androidTest/' folder and jUnit to implement unit tests located into 'characters' and 'detail' modules 'src/test/' folder

this app contains 5 modules:

app module: this is the main module of the app. In this module I have the MarvelApplication and di
(dagger 2) classes to define the necessary dependencies to inject, this module know and depend of
the other 4 modules.

core module: in this module we have the common classes that it will be used for the other modules.
This module only have knowledge of the "navigation" module.

characters module: contains all classes and references of marvel character list feature. this module
depends of "core" and "navigation" module

details module: constains all classes and references of marvel detail feature, is separated of list
feature to improve the reusability of the views and viewModels contained on it. This module has
dependecy of "core" and "navigation" module.

navigation module: this module manage all features related with navigation, i used navigation
component cause is a google library that it can restore the state of the navigation stack after
a process death. Every logic about navigation is encapsulated in this module.
This module has no dependencies with other modules.

--------------------------------------------------------------------------------------------
If I would have more time I would implemented more unit and instrumented tests using mockwebserver to mock
server responses and I would migrate from LiveData to Flow and from Dagger 2 to Hilt.

