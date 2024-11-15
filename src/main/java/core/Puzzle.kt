package core

enum class Puzzle {
    THE_KINGDOM_OF_ALGORITHMIA;

    fun getShortName(): String = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> "tkoa"
    }

    fun getDayCount(): Int = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> 20
    }

    fun getLongName(): String = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> "The Kingdom of Algorithmia"
    }
}