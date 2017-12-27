package edu.csh.chase.jschema.models

import edu.csh.chase.jschema.models.constraints.Constraint
import edu.csh.chase.jschema.parser.ConstraintParser
import edu.csh.chase.jschema.parser.ConstraintSerializer

class ConstraintWrapper<T : Constraint<*>>(val name: String, val clazz: Class<T>, parser: ConstraintParser<T>, serializer: ConstraintSerializer<T>) {
}