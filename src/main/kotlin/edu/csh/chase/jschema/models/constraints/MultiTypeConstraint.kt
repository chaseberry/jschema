package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.Type
import edu.csh.chase.jschema.models.ValidationCheck
import edu.csh.chase.jschema.JSchemaUtils as Utils

class MultiTypeConstraint(val types: List<Type>, config: JSchemaConfig) : Constraint("type", null, config) {

    override fun checkValidity(check: ValidationCheck) {
        types.forEachIndexed { i, it ->
            if (it !in config.types) {
                check.error("$it is not a valid type [$i]")
            }
        }

        if (types.intersect(types).isNotEmpty()) {
            check.error("type array needs to be unique")
        }
    }

    override fun validateValue(value: Any?): Boolean {
        return types.find { it.check(value) } != null
    }

}