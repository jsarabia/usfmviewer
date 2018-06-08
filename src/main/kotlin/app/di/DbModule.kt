package app.di

import dagger.Module
import dagger.Provides
import data.persistence.UsfmViewerDatabase
import persistence.repo.Db
import javax.inject.Singleton

@Module
class DbModule {
    @Provides
    @Singleton
    fun provideUsfmViewerDatabase() : UsfmViewerDatabase = Db()
}