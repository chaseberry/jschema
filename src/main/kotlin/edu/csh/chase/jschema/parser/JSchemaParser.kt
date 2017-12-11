package edu.csh.chase.jschema.parser

import edu.csh.chase.jschema.models.constraints.ConstantConstraint

object JSchemaParser {

    val parsers = listOf(
            ConstraintParser("const") {
                ConstantConstraint(it)
            }
    )

}