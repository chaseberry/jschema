http://json-schema.org/latest/json-schema-core.html

* Schema is an object or boolean (4.3.1)
* Ignore unknown keys (4.3.1, 6.4)
* Support custom keywords (4.3.2, 6.4)

* `$schema` URI (7)
* `$ref` URI - Does not need to download, but can (8)
* `$id` URI - Should not be `` or `#`, URI should not have `#`, unless empty, subschema ids must be `#` only (9.2)
* Multiple loaded schemas with the same `$id` value is an error (9.2.2)
* `$comment` String - Can be used in error/debug output, may remove key if a shortened version is requested (10)

http://json-schema.org/latest/json-schema-validation.html

* Apply root schema to entire instance document (3.1)
* Absence of validation keywords does not restrict validation - can act as no-op to value with specific value (3.2)
* If the type of the value is not compatible with the keywords target type, the value is valid in regards to that keyword (3.2.1)
* Annotations must be ignored inside a `not` subschema and inside failing branches of `oneOf`, `anyOf`, `then`, or `else` (3.3)
* The nul(\u0000) character is valid inside of a string (4.1)
* Regex is defined from `ecma262` and are not anchored (4.3)