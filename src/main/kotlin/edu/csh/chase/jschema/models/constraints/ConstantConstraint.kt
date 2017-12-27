package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

class ConstantConstraint(value: Any?, config: JSchemaConfig) : Constraint<Any>(value, config) {

    override fun validateConstraint() {}

    override fun validateValue(value: Any?): Boolean {
        return value == this.value
    }

}