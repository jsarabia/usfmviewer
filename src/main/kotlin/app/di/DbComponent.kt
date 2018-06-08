package app.di

import dagger.Component
import data.persistence.UsfmViewerDatabase
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class])
interface DbComponent {
    fun inject(): UsfmViewerDatabase
}