package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig

class EnumConstraint<T : List<Any?>>(value: T, config: JSchemaConfig) : Constraint<T>("enum", value, config) {

    override fun checkSet() {
        value?.let {
            if (it.isEmpty()) {
                warn("`enum` value should contain at least 1 element")
            }

            if (it.intersect(it).isNotEmpty()) {
                warn("`enum` value should be an array of unique values")
            }
        }
    }

    override fun validate(value: Any?): Boolean {
        return this.value?.contains(value) ?: true
    }
}