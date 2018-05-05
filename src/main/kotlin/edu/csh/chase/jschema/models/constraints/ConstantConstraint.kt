package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

class ConstantConstraint(val constant: Any?, config: JSchemaConfig) : Constraint("const", null, config) {

    override fun validateValue(value: Any?): Boolean {
        return constant == value
    }

}