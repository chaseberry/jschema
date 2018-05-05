package edu.csh.chase.jschema.models.types

import edu.csh.chase.jschema.models.Type

object NullType : Type("null") {

    override fun check(value: Any?): Boolean {
        return value == null
    }

    override fun convert(value: Any?): Any? {
        return value
    }
}