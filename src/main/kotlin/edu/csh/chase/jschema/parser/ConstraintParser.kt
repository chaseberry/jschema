package edu.csh.chase.jschema.parser

import edu.csh.chase.jschema.models.constraints.Constraint

class ConstraintParser(val name: String, parse: (Any?) -> Constraint<*>)