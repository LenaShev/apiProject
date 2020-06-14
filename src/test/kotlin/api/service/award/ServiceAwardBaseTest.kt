package api.service.award

import qa.config.Environment.PROD
import qa.config.SystemEnvironment.ENV

object ServiceAwardBaseTest {
    var PROGRAM_ID = if (ENV == PROD) 197674 else 196174
}