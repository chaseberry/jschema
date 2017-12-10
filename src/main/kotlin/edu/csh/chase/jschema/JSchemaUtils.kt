package edu.csh.chase.jschema

object JSchemaUtils {

    fun warn(warning: String, config: JSchemaConfig) {
        when {
            config.errOnWarn -> throw RuntimeException(warning)//TODO make an exception
            config.debugEnabled -> println(warning)//TODO use a logger
        }
    }

    fun error(s: String, config: JSchemaConfig) {

    }

    val validTypes = listOf(
            "null",
            "boolean",
            "object",
            "array",
            "number",
            "string",
            "integer"
    )

}