package edu.csh.chase.jschema.models

import edu.csh.chase.kjson.JsonArray
import edu.csh.chase.kjson.JsonObject

sealed class JsonValue(open val value: Any?) {

    class Boolean(override val value: kotlin.Boolean) : JsonValue(value)
    sealed class Number(override val value: kotlin.Number) : JsonValue(value) {
        class Int(override val value: kotlin.Int) : Number(value)
        class Double(override val value: kotlin.Double) : Number(value)
    }

    class String(override val value: kotlin.String) : JsonValue(value)
    class Array(override val value: JsonArray) : JsonValue(value)
    class Object(override val value: JsonObject) : JsonValue(value)
    class Null : JsonValue(null)

    companion object {
        fun from(v: Any?): JsonValue? = when (v) {
            null -> Null()
            is kotlin.Boolean -> Boolean(v)
            is kotlin.Int -> Number.Int(v)
            is kotlin.Double -> Number.Double(v)
            is kotlin.String -> String(v)
            is JsonObject -> Object(v)
            is JsonArray -> Array(v)
            else -> null
        }
    }

}