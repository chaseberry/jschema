package edu.csh.chase.jschema

data class JSchemaConfig(val errOnFailure: Boolean = false, val errOnWarn: Boolean = false,
                         val debugEnabled: Boolean = false, val formatIsConstraint: Boolean = true) {
}