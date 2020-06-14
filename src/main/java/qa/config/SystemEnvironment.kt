package qa.config

import qa.config.Environment.*

object SystemEnvironment {

    val ENV =
         when (System.getProperty("system.env")) {
            "DEV" -> DEV
            "QA" -> QA
            "PROD" -> PROD
            else -> DEFAULT
        }

}