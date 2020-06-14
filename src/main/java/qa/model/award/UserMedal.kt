package qa.model.award

data class UserMedal(
        val userId: Int,
        val programId: Int,
        var id: String = "",
        val type: String,
        var color: String = ""
)