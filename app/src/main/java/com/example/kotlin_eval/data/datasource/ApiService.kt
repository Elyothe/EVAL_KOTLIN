package com.example.kotlin_eval.data.datasource

import com.example.kotlin_eval.domain.models.Character
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Obtenir un personnage par son ID
    @GET("agents/{id}")
    suspend fun getCharacterById(@Path("id") id: String): Character

    // Obtenir tous les personnages
    @GET("agents")
    suspend fun getAllCharacters(): List<Character>

    // Rechercher des personnages par nom
    @GET("agents/search")
    suspend fun searchCharacters(@Query("query") query: String): List<Character>
}
