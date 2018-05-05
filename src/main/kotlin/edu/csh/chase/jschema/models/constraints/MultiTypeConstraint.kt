package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.Type
import edu.csh.chase.jschema.JSchemaUtils as Utils

class MultiTypeConstraint(val types: List<Type>, config: JSchemaConfig) : Constraint("type", null, config) {

    override fun validateConstraint() {
        types.forEachIndexed { i, it ->
            if (it !in config.types) {
                error("$it is not a valid type [$i]")
            }
        }

        if (types.intersect(types).isNotEmpty()) {
            error("type array needs to be unique")
        }
    }

    override fun validateValue(value: Any?): Boolean {
        return types
    }

}