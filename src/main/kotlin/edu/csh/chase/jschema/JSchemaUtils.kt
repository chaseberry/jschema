package edu.csh.chase.jschema

object JSchemaUtils {

    fun warn(warning: String, config: JSchemaConfig) {
        when {
            config.errOnWarn -> throw RuntimeException(warning)//TODO make an exception
            config.debugEnabled -> println(warning)//TODO use a logger
        }
    }

}