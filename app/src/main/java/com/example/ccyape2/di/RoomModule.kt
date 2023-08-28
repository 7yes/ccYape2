package com.example.ccyape2.di

import android.content.Context
import androidx.room.Room
import com.example.ccyape2.data.database.db.RecipeDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val RECIPE_DB_NAME = "recipe_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RecipeDB::class.java,
        RECIPE_DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: RecipeDB) = db.getRecipeDao()
}