package com.example.foody.data.database

import androidx.room.*
import com.example.foody.data.database.entities.FavoritesEntity
import com.example.foody.data.database.entities.RecipesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipesEntity: RecipesEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query(value = "SELECT * FROM recipes_table ORDER BY id ASC")
    fun readRecipes(): Flow<List<RecipesEntity>>

    @Query(value = "SELECT * FROM favorite_recipes_table ORDER BY id ASC")
    fun readFavoritesRecipes(): Flow<List<FavoritesEntity>>

    @Delete
    suspend fun deleteFavoriteRecipe(favoritesEntity: FavoritesEntity)

    @Query(value = "DELETE FROM favorite_recipes_table")
    suspend fun deleteAllFavoriteRecipes()

}