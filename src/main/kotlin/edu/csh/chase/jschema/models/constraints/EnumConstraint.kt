package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

class EnumConstraint<T : List<Any?>>(override val value: T, config: JSchemaConfig) : Constraint<T>("enum", value, config) {

    override fun checkSet() {
        if (value.isEmpty()) {
            warn("`enum` value should contain at least 1 element")
        }

        if (value.intersect(value).isNotEmpty()) {
            warn("`enum` value should be an array of unique values")
        }
    }

    override fun validate(value: Any?): Boolean {
        return this.value.contains(value)
    }
}