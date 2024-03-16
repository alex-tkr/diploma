package ua.nure.calendar

// https://micronaut.io
object Micronaut {

    // Micronaut versions >= 4 doesn't work on Gradle version < 8.
    const val version = "3.10.1"

    object Inject {
        const val lib = "io.micronaut:micronaut-inject:${version}"
    }

    object Validation {
        const val lib = "io.micronaut:micronaut-validation:${version}"
    }

    object Runtime {
        const val lib = "io.micronaut:micronaut-runtime:${version}"
    }

    object Netty {
        const val lib = "io.micronaut:micronaut-http-server-netty:${version}"
    }

    object HttpClient {
        const val lib = "io.micronaut:micronaut-http-client:${version}"
    }

    object Reactor {
        const val version = "3.6.1"
        const val lib = "io.projectreactor:reactor-core:${version}"
    }

    object Management {
        const val lib = "io.micronaut:micronaut-management:${version}"
    }
}

