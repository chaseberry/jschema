package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.Type
import edu.csh.chase.jschema.models.ValidationCheck
import edu.csh.chase.jschema.JSchemaUtils as Utils

class SingleTypeConstraint(val type: Type, config: JSchemaConfig) : Constraint("type", null, config) {

    override fun checkValidity(check: ValidationCheck) {
        if (type !in config.types) {
            error("`$type` is not a valid type. Valid types are ${config.types}")
        }
    }

    override fun validateValue(value: Any?): Boolean {
        return type.check(value)
    }

}