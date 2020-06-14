package qa.utils

import io.restassured.common.mapper.TypeRef
import io.restassured.response.ValidatableResponse
import org.testng.Assert.fail

fun <T> ValidatableResponse.extractAs(typeRef: TypeRef<T>): T {
    this.extract().body().asString().ifBlank { fail("Ответ на запрос не содержит данных для десериализации") }
    return this
            .extract()
            .`as`(typeRef)
}