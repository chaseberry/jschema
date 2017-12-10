package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils

class EnumConstraint<T : List<Any?>>(value: T?, config: JSchemaConfig) : Constraint<T>("enum", value, config) {

    override fun checkSet() {
        value?.let {
            if (it.isEmpty()) {
                JSchemaUtils.warn("`enum` value should contain at least 1 element", config)
            }

            if (it.intersect(it).isNotEmpty()) {
                JSchemaUtils.warn("`enum` value should be an array of unique values", config)
            }
        }
    }

    override fun validate(value: Any?): Boolean {
        return this.value?.contains(value) ?: true
    }
}