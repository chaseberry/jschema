package edu.csh.chase.jschema.models.constraints

import edu.csh.chase.jschema.JSchemaConfig

sealed class TypeConstraint<T : Any>(override val value: T, config: JSchemaConfig) : Constraint<T>(value, config) {

    class Single(override val value: String, config: JSchemaConfig) : TypeConstraint<String>(value, config)

    class Multi(override val value: List<String>, config: JSchemaConfig) : TypeConstraint<List<String>>(value, config)

}