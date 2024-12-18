package com.example.kotlin_eval.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_eval.data.repositories.CharacterRepositoryImpl
import com.example.kotlin_eval.domain.models.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepositoryImpl()

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val charactersList = repository.getAllCharacters()
                _characters.value = charactersList
            } catch (e: Exception) {
                _errorMessage.value = "Une erreur est survenue : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
