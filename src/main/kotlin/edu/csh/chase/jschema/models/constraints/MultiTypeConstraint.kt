package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils as Utils

class MultiTypeConstraint(override val value: List<String>, config: JSchemaConfig) : Constraint<List<String>>("type", value, config) {

    override fun checkSet() {
        value.forEachIndexed { i, it ->
            if (it !in edu.csh.chase.jschema.JSchemaUtils.validTypes) {
                error("$it is not a valid type")
            }
        }

        if (value.intersect(value).isNotEmpty()) {
            error("type array need to be unique")
        }
    }

    override fun validate(value: Any?): Boolean {

    }

}