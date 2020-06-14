package qa.enum

enum class AwardServiceRequestParameters(val id: String) {
    USER_ID("UserId"),
    PROGRAM_ID("ProgramId"),
    PROGRAM_IDS("ProgramIds"),
    IS_NOTIFIED("IsNotified")
}