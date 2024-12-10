package core

enum class Puzzle {
    THE_KINGDOM_OF_ALGORITHMIA,
    YEAR_2024;

    fun getShortName(): String = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> "tkoa"
        YEAR_2024 -> "y2024"
    }

    fun getDayCount(): Int = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> 20
        YEAR_2024 -> 25
    }

    fun getLongName(): String = when (this) {
        THE_KINGDOM_OF_ALGORITHMIA -> "The Kingdom of Algorithmia"
        YEAR_2024 -> "Year 2024"
    }
}