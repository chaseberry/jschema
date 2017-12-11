package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils
import edu.csh.chase.jschema.models.constraints.Constraint

class JsonSchema(val config: JSchemaConfig = JSchemaConfig()) {

    private val constraints = HashMap<String, Constraint<*>>()

    private val annotations = HashMap<String, Any?>()//TODO Custom annotation type?

    fun addConstraint(constraint: Constraint<*>) {
        if (constraint.name in annotations) {
            annotations.remove(constraint.name)
            JSchemaUtils.warn("Constraint ${constraint.name} overrides annotation", config)
        }
        constraint.checkSet()
        constraints[constraint.name] = constraint
    }

    fun removeConstraint(constraint: Constraint<*>) {
        removeConstraint(constraint.name)
    }

    fun removeConstraint(name: String) {
        constraints.remove(name)
    }

    fun addAnnotation(name: String, value: Any?) {
        if (name in constraints) {
            JSchemaUtils.warn("Annotation $name conflicts with a Constraint", config)
            return
        }
        annotations[name] = value
    }

    fun validate(value: Any?): Boolean {

    }

}