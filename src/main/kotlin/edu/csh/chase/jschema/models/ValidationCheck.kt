package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.JSchemaConfig

class ValidationCheck(private val config: JSchemaConfig) {

    val results = ArrayList<Check>()

    fun error(str: String) {
        results.add(Check.Error(str))
    }

    fun warn(str: String) {
        results.add(Check.Warn(str))
    }

    sealed class Check(val message: String) : {
        class Error(msg: String) : Check(msg)
        class Warn(msg: String) : Check(msg)
    }

    fun isValid() = when {
        config.errOnWarn && config.errOnFailure -> results.isNotEmpty()
        config.errOnFailure -> results.filterIsInstance(Check.Error::class.java).isNotEmpty()
        config.errOnWarn -> results.filterIsInstance(Check.Warn::class.java).isNotEmpty()
        else -> true
    }

}