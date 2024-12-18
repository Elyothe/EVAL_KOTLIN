package com.example.kotlin_eval.data.mocks


import com.example.kotlin_eval.domain.models.Character

object MockCharacters {
    val characters = listOf(
        Character(
            uuid = "1",
            displayName = "Jett",
            description = "Jett est un agent agile capable de se déplacer rapidement sur le champ de bataille.",
            role = "Duelliste"
        ),
        Character(
            uuid = "2",
            displayName = "Phoenix",
            description = "Phoenix manie le feu, lui permettant d'attaquer et de se soigner.",
            role = "Duelliste"
        ),
        Character(
            uuid = "3",
            displayName = "Sova",
            description = "Sova utilise des flèches de reconnaissance pour détecter ses ennemis.",
            role = "Initiateur"
        ),
        Character(
            uuid = "4",
            displayName = "Sage",
            description = "Sage est capable de soigner ses coéquipiers et de créer des murs protecteurs.",
            role = "Sentinelle"
        ),
        Character(
            uuid = "5",
            displayName = "Brimstone",
            description = "Brimstone apporte un soutien stratégique avec des fumigènes et des attaques orbitales.",
            role = "Contrôleur"
        ),
        Character(
            uuid = "6",
            displayName = "Reyna",
            description = "Reyna se nourrit de ses ennemis pour se renforcer et se soigner.",
            role = "Duelliste"
        ),
        Character(
            uuid = "7",
            displayName = "Cypher",
            description = "Cypher est un maître de la surveillance, capable de détecter les ennemis cachés.",
            role = "Sentinelle"
        )
    )
}
