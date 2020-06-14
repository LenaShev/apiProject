package qa.enum

enum class TestType(val id: String, val title: String, val sortNum: Int) {
    COMPLEX("Complex", "Комплексный (отдельный)", 2),
    INTERIM("Interim", "Промежуточная аттестация", 3),
    FINAL("Final", "Итоговая аттестация", 4),
    //   HIGH_SIMPLE( "HighSimple",  "Простой ВШГ", 5),
    INDIVIDUAL("Individual", "Вступительный тест", 6),
    PRACTICE_ALL_QUESTIONS("PracticeAllQuestions", "Практика/Все вопросы программы", 7),
    PRACTICE_EXPRESS("PracticeExpress", "Практика/Экспресс тест", 8),
    PRACTICE_MARATHON("PracticeMarathon", "Практика/Марафон", 9),
    ENTRANCE("Entrance", "Входное тестирование", 18),
    REPETITION("Repetition", "Повторение пройденного", 19)
}