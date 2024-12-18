package com.example.kotlin_eval.domain.models

//Mon modéle Characters
    data class Character(
        val uuid: String,
        val displayName: String,
        val description: String,
        val role: String,
    )
