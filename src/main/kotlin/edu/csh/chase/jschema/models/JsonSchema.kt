package edu.csh.chase.jschema.models

class JsonSchema {

    private val constraints = HashMap<String, Constraint<*>>()

    fun addConstraint(constraint: Constraint<*>) {
        constraint.checkSet()
        constraints[constraint.name] = constraint
    }

    fun removeConstraint(constraint: Constraint<*>) {
        removeConstraint(constraint.name)
    }

    fun removeConstraint(name: String) {
        constraints.remove(name)
    }

}