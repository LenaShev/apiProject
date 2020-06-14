package qa.config

enum class Environment {
    DEFAULT {
        override fun getProperties() = EnvironmentProperties.get("default.properties")
    },
    DEV {
        override fun getProperties() = EnvironmentProperties.get("dev.properties")
    },
    QA {
        override fun getProperties() = EnvironmentProperties.get("qa.properties")
    },
    PROD {
        override fun getProperties() = EnvironmentProperties.get("prod.properties")
    };

    abstract fun getProperties(): EnvironmentProperties?
}

