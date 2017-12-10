package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig

abstract class Constraint<T : Any>(val name: String, open val value: T?, val config: JSchemaConfig) {

    abstract fun checkSet()

    abstract fun validate(value: Any?): Boolean
}