package qa.config

import java.io.IOException
import java.util.*

class EnvironmentProperties() : Properties() {

    companion object {
        var environmentProperties = EnvironmentProperties()

        fun get(filePath: String): EnvironmentProperties {
            if (environmentProperties.isNullOrEmpty()) {
                try {
                    environmentProperties.load(this::class.java.getResourceAsStream("/properties/environment/" + filePath))
                } catch (e: IOException) {
                    throw  RuntimeException("Can't load properties file by path [/properties/environment" + filePath + "]")
                }
            }
            return environmentProperties;
        }
    }

    fun getAwardServiceUrl(): String = getProperty("award.service")
}