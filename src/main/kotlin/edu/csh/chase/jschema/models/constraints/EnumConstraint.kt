package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

class EnumConstraint<T : List<Any?>>(override val value: T, config: JSchemaConfig) : Constraint<T>(value, config) {

    override fun validateConstraint() {
        if (value.isEmpty()) {
            warn("`enum` value should contain at least 1 element")
        }

        if (value.intersect(value).isNotEmpty()) {
            warn("`enum` value should be an array of unique values")
        }
    }

    override fun validateValue(value: Any?): Boolean {
        return this.value.contains(value)
    }
}