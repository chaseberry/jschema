package edu.csh.chase.jschema.parser

import edu.csh.chase.jschema.models.JsonValue
import edu.csh.chase.jschema.models.constraints.Constraint

class ConstraintSerializer<T : Constraint<*>>(serialize: (T) -> JsonValue)