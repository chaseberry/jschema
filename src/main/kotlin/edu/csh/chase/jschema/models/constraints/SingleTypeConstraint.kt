package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils as Utils

class SingleTypeConstraint(override val value: String, config: JSchemaConfig) : Constraint<String>("type", value, config) {

    override fun checkSet() {
        if (value !in edu.csh.chase.jschema.JSchemaUtils.validTypes) {
            error("`$value` is not a valid type. Valid types are ${edu.csh.chase.jschema.JSchemaUtils.validTypes}")
        }
    }

    override fun validate(value: Any?): Boolean {

    }

}