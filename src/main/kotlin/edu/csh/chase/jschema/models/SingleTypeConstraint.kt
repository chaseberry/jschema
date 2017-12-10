package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils as Utils

class SingleTypeConstraint(value: String, config: JSchemaConfig) : Constraint<String>("type", value, config) {

    override fun checkSet() {
        if (value !in Utils.validTypes) {
            error("`$value` is not a valid type. Valid types are ${Utils.validTypes}")
        }
    }

    override fun validate(value: Any?): Boolean {

    }

}