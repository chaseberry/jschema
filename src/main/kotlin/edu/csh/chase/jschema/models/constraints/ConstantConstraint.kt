package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

class ConstantConstraint(value: Any?, config: JSchemaConfig) : Constraint<Any>("const", value, config) {

    override fun checkSet() {}

    override fun validate(value: Any?): Boolean {
        return value == this.value
    }

}