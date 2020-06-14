package qa.model.award


import java.time.LocalDateTime.now

data class QuizMedal(
        val quizzes: List<Quiz>,
        val userId: Int,
        val programId: Int,
        val isNotified: Boolean = true
)

data class Quiz(
        val sortNum: Int,
        val type: String,
        val isCompleted: Boolean = true,
        val endDate: String = now().toString(),
        val completedDate: String = now().toString()
)