package qa.service

import io.restassured.RestAssured.given
import io.restassured.common.mapper.TypeRef
import io.restassured.response.ValidatableResponse
import qa.config.SystemEnvironment.ENV
import qa.enum.AwardServiceRequestParameters.*
import qa.model.award.MedalView
import qa.model.award.QuizMedal
import qa.model.award.UserMedal
import qa.utils.extractAs
import java.net.HttpURLConnection.HTTP_OK
import kotlin.collections.set

object AwardServiceApi {

    val AWARD_SERVICE_URL = ENV.getProperties()?.getAwardServiceUrl()
    const val MEDAL_GRANT_URL = "/api/v1/medal/grant"
    const val MEDAL_URL = "/api/v1/medal"
    const val AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS = HTTP_OK

    //Создать медаль пользователя для программы
    fun createGrant(quizMedal: QuizMedal, expectedStatus: Int): String =
            createGrantResponse(quizMedal, expectedStatus)
                    .toString()

    //Создать медаль пользователя для программы
    fun createGrant(quizMedal: QuizMedal): UserMedal =
            createGrantResponse(quizMedal)
                    .extractAs(object : TypeRef<UserMedal>() {})

    //Получение списка медалей пользователя для программы
    fun getUserProjectMedals(userId: Int, programId: Int, isNotified: Boolean = false, expectedStatus: Int): String =
            getUserProjectMedalsResponse(userId, programId, isNotified, expectedStatus)
                    .toString()

    //Получение списка медалей пользователя для программы
    fun getUserProjectMedals(userId: Int, programId: Int, isNotified: Boolean = false): List<MedalView> =
            getUserProjectMedalsResponse(userId, programId, isNotified)
                    .extractAs(object : TypeRef<List<MedalView>>() {})

    //Удалить медаль пользователя
    fun deleteUserProjectMedals(userId: Int, programId: Int, expectedStatus: Int = AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS) {
        given()
                .baseUri(AWARD_SERVICE_URL)
                .param(USER_ID.id, userId)
                .param(PROGRAM_ID.id, programId)
                .`when`()
                .delete(MEDAL_URL)
                .then()
                .statusCode(expectedStatus)
    }

    private fun createGrantResponse(quizMedal: QuizMedal, expectedStatus: Int = AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS): ValidatableResponse =
            given()
                    .baseUri(AWARD_SERVICE_URL)
                    .`when`()
                    .body(quizMedal)
                    .post(MEDAL_GRANT_URL)
                    .then()
                    .statusCode(expectedStatus)

    private fun getUserProjectMedalsResponse(userId: Int, programId: Int, isNotified: Boolean = false, expectedStatus: Int = AWARD_REQUESTS_DEFAULT_POSITIVE_RESPONSE_STATUS): ValidatableResponse =
            given()
                    .baseUri(AWARD_SERVICE_URL)
                    .param(USER_ID.id, userId)
                    .param(PROGRAM_ID.id, programId)
                    .param(IS_NOTIFIED.id, isNotified)
                    .`when`()
                    .get(MEDAL_URL)
                    .then()
                    .statusCode(expectedStatus)

    private fun getProgramsParam(programIds: IntArray) = mutableMapOf<String, Any?>().apply { programIds.forEachIndexed { index, it -> this["${PROGRAM_IDS.id}[$index]"] = it } }
}