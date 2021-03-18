package com.example.weekthree.di

import android.content.Context
import com.example.weekthree.TuesdayApplication
import com.example.weekthree.di.module.AppModule
import com.example.weekthree.di.module.MainActivityModule
import com.example.weekthree.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component (
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent: AndroidInjector<TuesdayApplication> {

    @Component.Factory
    interface Factory {
        fun buildComponent(@BindsInstance context: Context): AppComponent
    }
}