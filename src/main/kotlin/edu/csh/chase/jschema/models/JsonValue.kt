package edu.csh.chase.jschema.models

import edu.csh.chase.kjson.JsonArray
import edu.csh.chase.kjson.JsonObject

sealed class JsonValue(open val value: Any?) {

    class Boolean(override val value: Boolean) : JsonValue(value)
    sealed class Number(override val value: Number) : JsonValue(value) {
        class Int(override val value: Int) : Number(value)
        class Double(override val value: Double) : Number(value)
    }

    class String(override val value: String) : JsonValue(value)
    class Array(override val value: JsonArray) : JsonValue(value)
    class Object(override val value: JsonObject) : JsonValue(value)
    class Null : JsonValue(null)
}