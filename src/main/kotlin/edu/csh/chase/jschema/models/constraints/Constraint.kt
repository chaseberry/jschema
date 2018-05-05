package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.JSchemaUtils
import edu.csh.chase.jschema.models.Type
import edu.csh.chase.jschema.models.ValidationCheck

abstract class Constraint(val name: String,
                          val valueType: Type? = null,
                          val config: JSchemaConfig) {

    protected open fun checkValidity(check: ValidationCheck) {}

    fun isValid() {

    }

    fun validate(value: Any?): Boolean {
        if (valueType == null || valueType.check(value)) {
            return validateValue(value)
        }

        return true
    }

    protected abstract fun validateValue(value: Any?): Boolean

    fun warn(warning: String) {
        JSchemaUtils.warn(warning, config)
    }

    fun error(error: String) {
        JSchemaUtils.error(error, config)
    }

}