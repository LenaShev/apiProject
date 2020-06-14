package qa.service

import qa.service.AwardServiceApi.AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS
import qa.service.AwardServiceApi.getUserProjectMedals
import kotlin.test.assertTrue

object AwardService {

    fun checkUserAwardIsEmpty(userId: Int, programId: Int) =
        getUserProjectMedals(userId = userId, programId = programId, expectedStatus = AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS).let {
            assertTrue(it.isBlank() || it.equals("[]"), "Награды пользователя $userId для программы $programId присутствуют в системе")
        }
}