package edu.csh.chase.jschema.models

abstract class Type(val name: String) {

    abstract fun check(value: Any?): Boolean

    abstract fun convert(value: Any?): Any?

}