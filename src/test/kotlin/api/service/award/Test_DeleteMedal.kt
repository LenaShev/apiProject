package api.service.award

import api.service.award.ServiceAwardBaseTest.PROGRAM_ID
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import qa.enum.TestType.INTERIM
import qa.model.award.Quiz
import qa.model.award.QuizMedal
import qa.service.AwardService.checkUserAwardIsEmpty
import qa.service.AwardServiceApi.createGrant
import qa.service.AwardServiceApi.deleteUserProjectMedals

class Test_DeleteMedal {

    private val userId = 1
    private val programId by lazy { PROGRAM_ID }

    @BeforeClass
    fun setUp() {
        createGrant(
                QuizMedal(
                        userId = userId,
                        programId = programId,
                        quizzes = listOf(
                                Quiz(
                                        sortNum = INTERIM.sortNum,
                                        type = INTERIM.id
                                )
                        )
                )
        )
    }

    @Test
    fun test_DeleteMedal() {
        deleteUserProjectMedals(userId, programId)
        checkUserAwardIsEmpty(userId, programId)
    }
}