package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.ValidationCheck

class EnumConstraint(val values: List<Any?>, config: JSchemaConfig) : Constraint("enum", null, config) {

    override fun checkValidity(check: ValidationCheck) {
        if (values.isEmpty()) {
            check.warn("`enum` value should contain at least 1 element")
        }

        if (values.intersect(values).isNotEmpty()) {
            check.warn("`enum` value should be an array of unique values")
        }
    }

    override fun validateValue(value: Any?): Boolean {
        return this.values.contains(value)
    }
}