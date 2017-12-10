package edu.csh.chase.jschema.dsl

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.Constraint
import edu.csh.chase.jschema.models.EnumConstraint
import edu.csh.chase.jschema.JSchemaUtils as Utils

class JsonSchema(private val config: JSchemaConfig = JSchemaConfig()) {

    val constraints = ArrayList<Constraint<*>>()

    var enum: List<Any?>? = null
        set(value) {
            constraints.add(EnumConstraint(value, config))
        }

}