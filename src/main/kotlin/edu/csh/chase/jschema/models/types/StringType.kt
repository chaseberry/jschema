package edu.csh.chase.jschema.models.types

import edu.csh.chase.jschema.models.Type

object StringType : Type("string") {

    override fun check(value: Any?): Boolean {
        return value != null && value is String
    }

    override fun convert(value: Any?): String {
        return value.toString()
    }


}