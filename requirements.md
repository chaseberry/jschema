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


## Validation Keywords

### type (6.1.1)
* Must be String or Array
* If array, each value must be a unique string
* Allowed values are `null`, `boolean`, `object`, `array`, `number`, `string`, `integer`
* The type of the value must be (in) the value of the type field

### enum (6.1.2)
* Must be an array
* Elements can be any value
* Should have at least 1 element
* Should be unique
* Value must be in array

### const (6.1.3)
* Can be any type
* Value must equal this

### multipleOf (6.2.1)
* Must be a number, > 0
* Value / this must be an int

### maximum (6.2.2)
* Must be a number
* Value must be <= this

### exclusiveMaximum (6.2.3)
* Must be a number
* Value must be < this

### minimum (6.2.4)
* Must be a number
* Value must be >= this

### exclusiveMinimum (6.2.5)
* Must be a number
* Value must be > this

### maxLength (6.3.1)
* Must be an int >= 0
* Value length must be <= this

### minLength (6.3.2)
* Must be an int >= 0
* Value length must be >= this
* Omitting this keyword is the same as supplying with a value of 0

### pattern (6.3.3)
* Must be a string
* Should be a regex
* Valid if the string matches this

### items (6.4.1)
* Must be an Schema or Array of Schemas
* If a single schema, validates all elements of an array against
* If array, validates each element against the schema at the same position
* Elements past the array size are valid
* Omitted is the same as supplying {}

### additionalItems (6.4.2)
* Must be a schema
* Applied to all elements past the items field size
* Must be ignored if items is a schema
* Omitted is the same as supplying {}