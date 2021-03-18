package com.example.weekthree.di.module

import com.example.weekthree.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun mainActivity(): MainActivity
}