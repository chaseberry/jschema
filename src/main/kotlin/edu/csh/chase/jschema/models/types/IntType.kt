package edu.csh.chase.jschema.models.types

import edu.csh.chase.jschema.models.Type

object IntType : Type("int") {

    override fun check(value: Any?): Boolean {
        return value != null && value is Int
    }

    override fun convert(value: Any?): Int {
        return when (value) {
            is Number -> value.toInt()
            is String -> value.toInt()
            else -> throw RuntimeException()
        }
    }

}