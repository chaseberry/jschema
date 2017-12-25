package edu.csh.chase.jschema.models

import edu.csh.chase.kjson.JsonArray
import edu.csh.chase.kjson.JsonObject

sealed class JsonValue {

    class Boolean(val boolean: Boolean) : JsonValue()
    sealed class Number(open val num: Number) : JsonValue() {
        class Int(override val num: Int) : Number(num)
        class Double(override val num: Double) : Number(num)
    }

    class String(val str: String) : JsonValue()
    class Array(val arr: JsonArray) : JsonValue()
    class Object(val obj: JsonObject) : JsonValue()

}