package edu.csh.chase.jschema

import edu.csh.chase.jschema.models.ValidationCheck

class InvalidConstraintException(val check: ValidationCheck) : IllegalArgumentException(
    check.getErrors().let { "${it.size} errors occurred. They are [${it.joinToString(", ")}]" }
        + check.getWarnings().let { "${it.size} warnings occurred. They are [${it.joinToString(", ")}]" }
) {

    val errors = check.getErrors()

    val warnings = check.getWarnings()

}