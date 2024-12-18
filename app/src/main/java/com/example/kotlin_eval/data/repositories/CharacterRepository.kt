package com.example.kotlin_eval.data.repositories

import com.example.kotlin_eval.domain.models.Character

interface CharacterRepository {
    suspend fun getCharacterById(id: String): Character
    suspend fun getAllCharacters(): List<Character>
    suspend fun searchCharacters(query: String): List<Character>
}
