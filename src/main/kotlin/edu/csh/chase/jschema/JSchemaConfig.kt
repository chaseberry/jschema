package edu.csh.chase.jschema

data class JSchemaConfig(val errOnFailure: Boolean = true, val errOnWarn: Boolean = false,
                         val debugEnabled: Boolean = false, val formatIsConstraint: Boolean = true,
                         val validTypes: List<String> = JSchemaUtils.defaultTypes) {
}