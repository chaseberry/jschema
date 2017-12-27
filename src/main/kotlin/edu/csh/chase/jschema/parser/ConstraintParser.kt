package edu.csh.chase.jschema.parser

import edu.csh.chase.jschema.JSchemaConfig
import edu.csh.chase.jschema.models.JsonValue
import edu.csh.chase.jschema.models.constraints.Constraint

class ConstraintParser<T : Constraint<*>>(parse: (JsonValue, JSchemaConfig) -> T)