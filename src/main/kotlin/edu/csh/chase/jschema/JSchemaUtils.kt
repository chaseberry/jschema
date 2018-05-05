package edu.csh.chase.jschema

import edu.csh.chase.jschema.models.types.IntType
import edu.csh.chase.jschema.models.types.NullType
import edu.csh.chase.jschema.models.types.StringType

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
        "null" to NullType,
        "int" to IntType,
        "integer" to IntType,
        "string" to StringType
    )

    var defaultConfig = JSchemaConfig()

}