package com.example.weekthree.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weekthree.annotations.ViewModelKey
import com.example.weekthree.di.ViewModelFactory
import com.example.weekthree.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun provideFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}