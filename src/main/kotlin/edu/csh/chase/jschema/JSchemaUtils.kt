package edu.csh.chase.jschema

import edu.csh.chase.jschema.models.types.IntType

object JSchemaUtils {

    fun warn(warning: String, config: JSchemaConfig) {
        when {
            config.errOnWarn -> throw RuntimeException(warning)//TODO make an exception
            config.debugEnabled -> println(warning)//TODO use a logger
        }
    }

    fun error(s: String, config: JSchemaConfig) {

    }

    val defaultTypes = mapOf(//TODO Type map - list/map String(name) - validation requirements
        "int" to IntType,
        "integer" to IntType
    )

    var defaultConfig = JSchemaConfig()

}