package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils

abstract class Constraint<T : Any>(val name: String, open val value: T?, val config: JSchemaConfig) {

    abstract fun checkSet()

    abstract fun validate(value: Any?): Boolean

    fun warn(warning: String) {
        JSchemaUtils.warn(warning, config)
    }

    fun error(error: String) {
        JSchemaUtils.error(error, config)
    }
}