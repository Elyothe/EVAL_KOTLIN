Bon,
Par où commencer...

1.Le commencement :

  - J'ai d'abord parcouru les API sur GitHub pour trouver chaussure à mon pied, j'ai fait moult tests et je suis parti sur une API de Valorant
    (Je ne joue pas à Valorant mais dans un souci de ne pas savoir quoi choisir...)
       L'API : https://valorant-api.com/v1/

2.Initiation du projet :

  - J'ai créé le projet (à part un bug au démarrage (Kotlin quoi), aucun problème (30 min quand même))
  - J'ai repris l'architecture de mon ancien projet et de ton git Rick et Morty et j'ai créé les dossiers nécessaires (j'aime quand c'est bien rangé)

3.Les ROUTES

  -J'ai créé mon NavController et j'ai mis en place mes routes pour avoir de la navigation dès le départ.

4.L'API

  - Je me suis focalisé sur les calls API, j'ai alors pris 3 heures pour comprendre comment fonctionnaient les calls API en Kotlin (C'est bien galère)

    - J'ai alors créé :
      - Un APIService (gère les calls)
      - Un RetrofitInstance (mettre à quoi ça sert)
      - Mon Model (Character)
      - Mes repositories (CharacterRepository & CharacterRepositoryIMPL)

  - Jusqu'ici tout allait bien (Après 5 cafés et 2 cocas), cependant je me suis retrouvé bloqué sur les calls,
    impossible pour moi de binder les réponses API à mon modèle.

5.Le MOCK

  - Après une bataille acharnée sur l'API, j'ai cherché à faire un MOCK pour gagner du temps et sortir quelque chose de propre.
  - J'ai alors recréé un MOCK sur mes models et repositories existants.

6.Le repas

  - C'était quand même l'heure de manger, anecdote pas très importante mais nécessaire de préciser (il était 19h30).

7.Les sons et vibrations

  - J'ai cherché à mettre en place un son et une vibration sur les clics de mes cards, je ne dois pas être très loin mais ça ne fonctionne pas encore.

8.Dark Mode et Day Mode

  - J'ai commencé à mettre en place une palette de couleurs pour appliquer un mode sombre et un mode clair automatiquement. 
    (Je n'ai pas réussi à finir cette partie)

9.Les langues

  - Par manque de temps, je n'ai malheureusement pas mis en place le choix des langues...

10. L'arborescence

    Directory structure:
└── Elyothe-EVAL_KOTLIN
    ├── gradle.properties
    ├── gradlew.bat
    ├── gradle
    │   ├── libs.versions.toml
    │   └── wrapper
    │       ├── gradle-wrapper.jar
    │       └── gradle-wrapper.properties
    ├── settings.gradle.kts
    ├── gradlew
    ├── README.md
    ├── build.gradle.kts
    └── app
        ├── .gitignore
        ├── proguard-rules.pro
        ├── build.gradle.kts
        └── src
            ├── main
            │   ├── AndroidManifest.xml
            │   ├── java
            │   │   └── com
            │   │       └── example
            │   │           └── kotlin_eval
            │   │               ├── domain
            │   │               │   └── models
            │   │               │       └── Character.kt
            │   │               ├── components
            │   │               │   └── BtnBack.kt
            │   │               ├── data
            │   │               │   ├── mocks
            │   │               │   │   └── MockCharacters.kt
            │   │               │   ├── repositories
            │   │               │   │   ├── CharacterRepositoryImpl.kt
            │   │               │   │   └── CharacterRepository.kt
            │   │               │   └── datasource
            │   │               │       ├── RetrofitInstance.kt
            │   │               │       └── ApiService.kt
            │   │               ├── ui
            │   │               │   ├── viewmodels
            │   │               │   │   └── CharacterViewModel.kt
            │   │               │   ├── screens
            │   │               │   │   ├── HomeScreen.kt
            │   │               │   │   └── DetailsScreen.kt
            │   │               │   ├── theme
            │   │               │   │   ├── Theme.kt
            │   │               │   │   ├── Type.kt
            │   │               │   │   └── Color.kt
            │   │               │   └── Routes.kt
            │   │               └── MainActivity.kt
            │   └── res
            │       
            │       ├── raw
            │       │   └── click.mp3
            │       ├── mipmap-xhdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── values-night
            │       │   └── color.xml
            │       └── values
            │           ├── strings.xml
            │           ├── themes.xml
            │           └── colors.xml
            ├── test
            │   └── java
            │       └── com
            │           └── example
            │               └── kotlin_eval
            │                   └── ExampleUnitTest.kt
            └── androidTest
                └── java
                    └── com
                        └── example
                            └── kotlin_eval
                                └── ExampleInstrumentedTest.kt


11.La fin

  - À l'heure où j'écris ces lignes, il est 22h50, je crois que je ne pourrai aller plus loin... Ce fut un plaisir... Adieu...
