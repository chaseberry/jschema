package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils
import edu.csh.chase.jschema.models.constraints.Constraint

class JsonSchema(val config: JSchemaConfig = JSchemaUtils.defaultConfig) {

    private val constraints = ArrayList<Constraint>()

    fun addConstraint(constraint: Constraint) {
        constraint.checkValidity()
        constraints.add(constraint)
    }

    fun removeConstraint(constraint: Constraint) {
        removeConstraint(constraint.name)
    }

    fun removeConstraint(name: String) {
        constraints.removeIf { it.name == name }
    }

    fun validate(value: Any?): Boolean {
        constraints.forEach {
            if (!it.value.validate(value)) {
                return false
            }
        }
        return true
    }

}