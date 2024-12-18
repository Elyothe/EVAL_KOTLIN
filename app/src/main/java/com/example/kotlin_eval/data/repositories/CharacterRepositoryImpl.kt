package com.example.kotlin_eval.data.repositories

import com.example.kotlin_eval.domain.models.Character
import com.example.kotlin_eval.data.mocks.MockCharacters

class CharacterRepositoryImpl : CharacterRepository {

    // Retourne tous les personnages fictifs
    override suspend fun getAllCharacters(): List<Character> {
        return MockCharacters.characters // On retourne la liste statique
    }

    // Trouve un personnage par son UUID
    override suspend fun getCharacterById(id: String): Character {
        return MockCharacters.characters.firstOrNull { it.uuid == id }
            ?: throw Exception("Personnage avec l'ID $id non trouvé")
    }

    // Recherche des personnages par nom
    override suspend fun searchCharacters(query: String): List<Character> {
        return MockCharacters.characters.filter {
            it.displayName.contains(query, ignoreCase = true)
        }
    }
}
