package edu.csh.chase.jschema

import edu.csh.chase.jschema.dsl.JsonSchemaDSL

fun main(args: Array<String>) {

    schema {
        type("string")
        enum("user", "truck", "stationAlert")
    }

}

fun schema(schema: JsonSchemaDSL.() -> Unit): JsonSchemaDSL {
    return JsonSchemaDSL().apply(schema)
}
