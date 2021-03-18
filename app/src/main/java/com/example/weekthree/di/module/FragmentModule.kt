package com.example.weekthree.di.module

import com.example.weekthree.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract fun homeFragment(): HomeFragment
}