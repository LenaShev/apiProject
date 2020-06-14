package api.service.award

import api.service.award.ServiceAwardBaseTest.PROGRAM_ID
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import qa.service.AwardService.checkUserAwardIsEmpty
import qa.service.AwardServiceApi.deleteUserProjectMedals
import java.net.HttpURLConnection.HTTP_BAD_REQUEST


class Test_DeleteMedal_NoMedal {

    private val userId = 1
    private val programId by lazy { PROGRAM_ID }

    @BeforeClass
    fun setUp() {
        checkUserAwardIsEmpty(userId, programId)
    }

    @Test
    fun test_DeleteMedal_NoMedal() {
        deleteUserProjectMedals(userId, programId, HTTP_BAD_REQUEST)
        checkUserAwardIsEmpty(userId, programId)
    }
}