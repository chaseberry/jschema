package edu.csh.chase.jschema

import edu.csh.chase.jschema.models.Type

data class JSchemaConfig(val errOnFailure: Boolean = true,
                         val errOnWarn: Boolean = false,
                         val debugEnabled: Boolean = false,
                         val formatIsConstraint: Boolean = true,
                         val types: List<Type> = JSchemaUtils.defaultTypes.values.distinct()) {
}