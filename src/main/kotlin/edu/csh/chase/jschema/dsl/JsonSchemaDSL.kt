package edu.csh.chase.jschema.dsl

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.Constraint
import edu.csh.chase.jschema.models.EnumConstraint
import edu.csh.chase.jschema.models.MultiTypeConstraint
import edu.csh.chase.jschema.models.SingleTypeConstraint
import edu.csh.chase.jschema.JSchemaUtils as Utils

class JsonSchemaDSL(private val config: JSchemaConfig = JSchemaConfig()) {

    val constraints = HashMap<String, Constraint<*>>()

    fun enum(vararg contains: Any?) {
        constraints["enum"] = EnumConstraint(contains.asList(), config).apply { checkSet() }
    }

    fun type(vararg type: String) {
        when (type.size) {
            1 -> constraints["type"] = SingleTypeConstraint(type[0], config)
            else -> type(type.asList())
        }
    }

    fun type(types: List<String>) {
        constraints["type"] = MultiTypeConstraint(types, config)
    }


}